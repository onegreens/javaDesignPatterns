package com.cl.threadCore.chapter1;

/**
 * 线程优先级的继承特性
 */
public class SPriority {
    public static void main(String[] args) {
        System.out.println("main begin run priority: " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main end run priority: " + Thread.currentThread().getPriority());
        SThread1 thread1 = new SThread1();
        thread1.start();
    }
}

class SThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("SThread1 run priority: " + this.getPriority());
        SThread2 thread2 = new SThread2();
        thread2.start();
    }
}

class SThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("SThread2 run priority: " + this.getPriority());
    }
}
