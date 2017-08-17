package com.cl.javaNote.threadNote.blocked;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/9.
 * Executor中interrupt()的基本用法
 *
 * 说明I/O和在synchronized块上的等待是不可中断的
 */
public class Interrupting {
    private static ExecutorService executorService = Executors.newCachedThreadPool();
    static void test(Runnable r) throws InterruptedException {
        Future<?> f = executorService.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("interrupting "+r.getClass().getName());
        f.cancel(true);
        System.out.println("interripting send to "+r.getClass().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        test(new SleepBlocker());
        test(new IOBlocked(System.in));
        test(new SynchronizedBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("系统退出");
        System.exit(0);
    }
}

/**
 * 可中断的阻塞示例
 */
class SleepBlocker implements Runnable {

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("interruptException");
        }
        System.out.println("Exiting SleepBlocker.run()");
    }
}
/**
 * 不可中断的阻塞示例
 */
class IOBlocked implements Runnable {
    private InputStream in;

    public IOBlocked(InputStream in) {
        this.in = in;
    }

    public void run() {
        try {
            System.out.println("等待读取");
            in.read();

        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("interrupt from block i/o ");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
/**
 * 不可中断的阻塞示例
 */
class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true)
            Thread.yield();
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }

    public void run() {
        System.out.println("try to call f()");
        f();
        System.out.println("Exiting SynchronizedBlocked.run()");
    }
}