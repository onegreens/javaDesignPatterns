package com.cl.threadCore.chapter1;

/**
 * 测试 isInterrupted
 */
public class GInterrupted extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000000; i++) {
            if (i % 10000 == 0)
                System.out.println("count = " + i);
        }
    }

    public static void main(String[] args) {
        try {
            GInterrupted thread = new GInterrupted();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
            System.out.println("是否停止:" + thread.isInterrupted());//true
            System.out.println("是否停止:" + thread.isInterrupted());//true
            System.out.println("end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
