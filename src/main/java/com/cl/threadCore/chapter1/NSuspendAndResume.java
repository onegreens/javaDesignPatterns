package com.cl.threadCore.chapter1;

/**
 * suspend 暂停线程
 * resume 恢复线程
 */
public class NSuspendAndResume extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true)
        i++;
    }

    public static void main(String[] args) {
        try {
            NSuspendAndResume thread = new NSuspendAndResume();
            thread.start();
            Thread.sleep(2000);
            //A段
            thread.suspend();
            System.out.println("A time:" + System.currentTimeMillis() + " i:" + thread.getI());
            Thread.sleep(2000);
            System.out.println("A time:" + System.currentTimeMillis() + " i:" + thread.getI());
            //B段
            thread.resume();
            Thread.sleep(2000);
            //C段
            thread.suspend();
            System.out.println("C time:" + System.currentTimeMillis() + " i:" + thread.getI());
            Thread.sleep(2000);
            System.out.println("C time:" + System.currentTimeMillis() + " i:" + thread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
