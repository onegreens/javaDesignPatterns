package com.cl.threadCore.chapter2.section2;

public class SynDefect {
    public static void main(String[] args) {
        SDTask task = new SDTask();
        SDThread1 thread1 = new SDThread1(task);
        thread1.start();
        SDThread2 thread2 = new SDThread2(task);
        thread2.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时:" + ((SDTimeUtil.endTime1 > SDTimeUtil.endTime2 ? SDTimeUtil.endTime1 : SDTimeUtil.endTime2)
                - (SDTimeUtil.beginTime1 > SDTimeUtil.beginTime2 ? SDTimeUtil.beginTime2 : SDTimeUtil.beginTime1)));
    }
}

class SDTask {
    private String getData1;
    private String getData2;

    public synchronized void doLongTimeSDTask() {
        try {
            System.out.println("begin task");
            getData1 = "getData1  Thread name = " + Thread.currentThread().getName();
            getData2 = "getData2  Thread name = " + Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SDThread1 extends Thread {
    SDTask task;

    public SDThread1(SDTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        SDTimeUtil.beginTime1 = System.currentTimeMillis();
        task.doLongTimeSDTask();
        SDTimeUtil.endTime1 = System.currentTimeMillis();

    }
}

class SDThread2 extends Thread {
    public SDThread2(SDTask task) {
        this.task = task;
    }

    SDTask task;

    @Override
    public void run() {
        SDTimeUtil.beginTime2 = System.currentTimeMillis();
        task.doLongTimeSDTask();
        SDTimeUtil.endTime2 = System.currentTimeMillis();

    }
}

class SDTimeUtil {
    public static Long beginTime1;
    public static Long endTime1;
    public static Long beginTime2;
    public static Long endTime2;
}