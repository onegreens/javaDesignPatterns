package com.cl.javaNote.threadNote;

import java.util.concurrent.TimeUnit;


/**
 * Created by cl on 2017/8/7.
 * 后台线程：指在程序运行的时候在后台提供的一种通用服务的线程
 * 这种线程并不属于程序中不可中不可或缺的部分
 *
 */
public class SimpleDaemons implements Runnable {

    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + "" +this);
            }
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread darom = new Thread(new SimpleDaemons());
            //必须在线程启动之前调用setDaemon()方法,设置为后台线程
            darom.setDaemon(true);
            darom.start();
        }
        System.out.println("all daeons started");
        TimeUnit.MILLISECONDS.sleep(100);

    }
}
