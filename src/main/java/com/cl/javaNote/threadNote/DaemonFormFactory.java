package com.cl.javaNote.threadNote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/7.
 * 利用ExecutorService和ThreadFactory创建后台线程
 */
public class DaemonFormFactory implements Runnable {
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //每个静态的ExecutorService创建方法都被重载为接收一个ThreadFactory对象，而这个对象则被用来创建新的线程
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFormFactory());
        }
        System.out.println("all daemons started");
        TimeUnit.MILLISECONDS.sleep(500);
    }
}
