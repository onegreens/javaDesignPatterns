package com.cl.threadCore.chapter1;

public class DSleep extends Thread {
    public static void main(String[] args) {
        DSleep sleep = new DSleep();
        System.out.println(" main begin : " + Thread.currentThread().getName() + " time : " + System.currentTimeMillis());
        sleep.start();
        System.out.println(" main end : " + Thread.currentThread().getName() + " time : " + System.currentTimeMillis());

    }

    @Override
    public void run() {
        System.out.println(" run begin : " + Thread.currentThread().getName() + " time : " + System.currentTimeMillis());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" run end : " + Thread.currentThread().getName() + " time : " + System.currentTimeMillis());
    }
}
