package com.cl.threadCore.chapter1;

public class KStop extends Thread {
    @Override
    public void run() {
        super.run();
        int i = 0;
        try {
            while (true){

                i++;
                System.out.println("count : " + i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        KStop thread = new KStop();
        thread.start();
        Thread.sleep(1000);
        thread.stop();
    }
}
