package com.cl.threadCore.chapter1;

/**
 * 守护线程
 */
public class ODaemon extends Thread {
    private int i = 0;

    @Override
    public void run() {

        try {
            while (true) {
                System.out.println("i = " + i++);
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ODaemon thread = new ODaemon();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        System.out.println("停止了");
    }
}
