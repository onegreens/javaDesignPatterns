package com.cl.threadCore.chapter1;

public class ASharedData extends Thread{
    public static void main(String[] args) {
        ASharedData thread = new ASharedData();
        Thread a = new Thread(thread, "A");
        Thread b = new Thread(thread, "B");
        Thread c = new Thread(thread, "C");
        Thread d = new Thread(thread, "D");
        Thread e = new Thread(thread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    private int count = 5;

//    @Override
//    public void run() {
//        count--;
//        System.out.println("由" + Thread.currentThread().getName() + "计算:" + count);
//    }

    @Override
    public synchronized void run() {//添加同步控制
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算:" + count);
    }
}
