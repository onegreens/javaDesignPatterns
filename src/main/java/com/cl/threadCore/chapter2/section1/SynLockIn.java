package com.cl.threadCore.chapter2.section1;

/**
 * 一个synchronized方法/块 可以调用类内部的其他同步方法
 *
 * 可重入锁
 */
public class SynLockIn {
    public synchronized void service1() {
        System.out.println("service1");
        service2();
    }

    public synchronized void service2() {
        System.out.println("service2");
        service3();
    }

    public synchronized void service3() {
        System.out.println("service3");
    }

    public static void main(String[] args) {
        new SLIThread().start();
    }
}
class SLIThread extends  Thread{
    @Override
    public void run() {
        SynLockIn synLockIn =new SynLockIn();
        synLockIn.service1();
    }
}
