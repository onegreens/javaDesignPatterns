package com.cl.javaNote.threadNote.cooperation;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/10.
 * <p>
 * 使用notify()时，只会有一个线程被唤醒
 * 多任务的话，先考虑notifyAll()
 * <p>
 * 当notifuAll()因某个特定的锁而被调用时，只有等待这个锁的任务才会被唤醒
 *
 * 实例：task1和task之间的notify不相互影响
 */
public class NotifyVSNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task1());
        }
        executorService.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean p = true;

            @Override
            public void run() {
                if (p) {
                    System.out.println("Task1 notify() ============");
                    Task1.blocker.prod();
                    p = false;
                } else {
                    System.out.println("Task1 notifyAll() ========");
                    Task1.blocker.prodAll();
                    p = true;
                }
            }
        }, 400, 400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("timer canceled ==========");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("task2 notifyAll() ============");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("shoudownNow()======");
        executorService.shutdownNow();

    }

}

class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println("current thread : " + Thread.currentThread());
            }
        } catch (InterruptedException e) {
            System.out.println("中断了。。。");
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}

class Task1 implements Runnable {
    static Blocker blocker = new Blocker();

    public void run() {
        blocker.waitingCall();
    }
}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker();

    public void run() {
        blocker.waitingCall();
    }
}