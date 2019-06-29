package com.cl.threadCore.chapter2.section2;

public class SynCodeBlockSolveDefect {
    public static void main(String[] args) {
        SCBTask task = new SCBTask();
        SCBThread1 thread1 = new SCBThread1(task);
        thread1.start();
        SCBThread2 thread2 = new SCBThread2(task);
        thread2.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("耗时:" + ((SCBTimeUtil.endTime1 > SCBTimeUtil.endTime2 ? SCBTimeUtil.endTime1 : SCBTimeUtil.endTime2)
                - (SCBTimeUtil.beginTime1 > SCBTimeUtil.beginTime2 ? SCBTimeUtil.beginTime2 : SCBTimeUtil.beginTime1)));
    }
}

class SCBTask {
    private String getData1;
    private String getData2;

    public void doLongTimeSCBTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);

            String privateData1 = "getData1  Thread name = " + Thread.currentThread().getName();
            String privateData2 = "getData2  Thread name = " + Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateData1;
                getData2 = privateData2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SCBThread1 extends Thread {
    SCBTask task;

    public SCBThread1(SCBTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        SCBTimeUtil.beginTime1 = System.currentTimeMillis();
        task.doLongTimeSCBTask();
        SCBTimeUtil.endTime1 = System.currentTimeMillis();

    }
}

class SCBThread2 extends Thread {
    public SCBThread2(SCBTask task) {
        this.task = task;
    }

    SCBTask task;

    @Override
    public void run() {
        SCBTimeUtil.beginTime2 = System.currentTimeMillis();
        task.doLongTimeSCBTask();
        SCBTimeUtil.endTime2 = System.currentTimeMillis();

    }
}

class SCBTimeUtil {
    public static Long beginTime1;
    public static Long endTime1;
    public static Long beginTime2;
    public static Long endTime2;
}
