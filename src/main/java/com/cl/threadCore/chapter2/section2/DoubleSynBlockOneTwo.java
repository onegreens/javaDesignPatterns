package com.cl.threadCore.chapter2.section2;

/**
 *     当一个线程访问Object的一个synchronized(this)同步代码块时,其他线程对Object的其他同步代码块的访问将被阻塞
 */
public class DoubleSynBlockOneTwo {
    public void testA() {
        synchronized (this){

            try {
                System.out.println("testa begin time " + System.currentTimeMillis() + " thread name " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("testa end time " + System.currentTimeMillis() + " thread name " + Thread.currentThread().getName());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void testB() {
        synchronized (this){

            System.out.println("testB begin time " + System.currentTimeMillis() + " thread name " + Thread.currentThread().getName());
            System.out.println("testB end time " + System.currentTimeMillis() + " thread name " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        DoubleSynBlockOneTwo method = new DoubleSynBlockOneTwo();
        DSBThreadA threadA = new DSBThreadA(method);
        threadA.start();
        DSBThreadB threadB = new DSBThreadB(method);
        threadB.start();
    }
}

class DSBThreadA extends Thread {
    DoubleSynBlockOneTwo method;

    public DSBThreadA(DoubleSynBlockOneTwo method) {
        this.method = method;
    }

    @Override
    public void run() {
        method.testA();
    }
}

class DSBThreadB extends Thread {
    DoubleSynBlockOneTwo method;

    public DSBThreadB(DoubleSynBlockOneTwo method) {
        this.method = method;
    }

    @Override
    public void run() {
        method.testB();
    }
}
