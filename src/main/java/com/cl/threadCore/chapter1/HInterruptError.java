package com.cl.threadCore.chapter1;

/**
 * 测试 isInterrupted
 */
public class HInterruptError extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000000; i++) {
            if (this.isInterrupted()) {
                System.out.println("线程停止了,退出");
                break;
            }
            if (i % 10000 == 0)
                System.out.println("count = " + i);
        }
        System.out.println("只是for停止了而已");
    }

    public static void main(String[] args) {
        try {
            HInterruptError thread = new HInterruptError();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
