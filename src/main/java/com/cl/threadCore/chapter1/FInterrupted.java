package com.cl.threadCore.chapter1;

/**
 * 测试 interrupted
 */
public class FInterrupted extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            if (i % 1000 == 0)
                System.out.println("count = " + i);
        }
    }

    public static void main(String[] args) {
        test1();
//        test2();
    }

    public static void test1()  {
        try {
            FInterrupted thread = new FInterrupted();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            System.out.println("是否停止:" + thread.interrupted());//false
            System.out.println("是否停止:" + thread.interrupted());//false
            System.out.println("end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        Thread.currentThread().interrupt();
        System.out.println("是否停止:" + Thread.interrupted());//true
        System.out.println("是否停止:" + Thread.interrupted());//false
        System.out.println("end!");
    }
}
