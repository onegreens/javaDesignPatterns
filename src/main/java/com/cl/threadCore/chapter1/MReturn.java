package com.cl.threadCore.chapter1;

/**
 * 使用return来终止线程
 * 但是会受到异常的影响
 */
public class MReturn extends Thread {
    @Override
    public void run() {
        while (true) {
            if (this.isInterrupted()) {
                System.out.println("线程停止了");
                return;
            }
            System.out.println(System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MReturn thread = new MReturn();
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
