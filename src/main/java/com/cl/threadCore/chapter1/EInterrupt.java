package com.cl.threadCore.chapter1;

/**
 * interrupt 并没有终止线程
 */
public class EInterrupt extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 500000; i++) {
            System.out.println("count = " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        EInterrupt thread = new EInterrupt();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
