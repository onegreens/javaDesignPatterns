package com.cl.javaNote.threadNote.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by cl on 2017/8/8.
 * 捕获线程中抛出的异常，是无法通过try捕获
 *
 * Thread.UncaughtExceptionHandler允许你在每个Thread对象上都附上一个异常处理器
 * Thread.UncaughtExceptionHandler.uncaughtException会在线程因未捕获的异常而临近死亡时被调用
 * 创建新类型的ThreadFactory，对每个创建的Thread附上异常处理
 */
class ExceptionThread implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("当前线程---" + t);
        System.out.println("eh --- " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

}

public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread());
    }

    /**
     * 在Thread类中设置一个静态域，并将这个处理器设置为默认的未捕获异常处理器
     *
     * 缺陷：只有在不存在线程转悠的未捕获异常处理器的情况下才会被调用
     * @param args
     */
    public static void main2(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ExceptionThread());
    }

}

class MyUnCaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception :" + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + "create new Thread");
        Thread t = new Thread(r);
        System.out.println("create " + t);
        t.setUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
        System.out.println("eh --- " + t.getUncaughtExceptionHandler());
        return t;
    }
}
