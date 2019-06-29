package com.cl.threadCore.chapter1;

/**
 * 测试 isInterrupted
 */
public class JInterruptInSleep extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在睡眠中被停止了");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            JInterruptInSleep thread = new JInterruptInSleep();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("捕捉到 main 输出的异常了");
            e.printStackTrace();
        }
    }

}
