package com.cl.javaNote.threadNote.base;

import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/7.
 * <p>
 * 通过调用isDaemon()方法确定线程是否为一个后台线程，如果是，那么它创建的线程自动设置为后台线程
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemin() = " + d.isDaemon() + " ,");
        TimeUnit.SECONDS.sleep(1);
    }

}

class Daemon implements Runnable {
    private Thread[] t = new Thread[10];

    public void run() {
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new DaemonSpawn());
            t[i].start();
            System.out.println("daemon " + i + " started");
        }
        for (int i = 0; i < t.length; i++) {
            System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + " ,");
        }
        while (true)
            Thread.yield();
    }
}

class DaemonSpawn implements Runnable {

    public void run() {
        while (true)
            Thread.yield();
    }
}