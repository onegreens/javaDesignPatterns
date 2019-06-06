package com.cl.threadCore.chapter1;

public class CIsAlive extends Thread {
    @Override
    public void run() {
        System.out.println("run : " + this.isAlive());
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
        test2();
    }
    public static void test1() {
        CIsAlive cIsAlive = new CIsAlive();
        System.out.println("Begin :" + cIsAlive.isAlive());//FALSE
        cIsAlive.start();
        System.out.println("END :" + cIsAlive.isAlive());//TRUE 但是值不确定

    }

    public static void test2() throws InterruptedException {
        CIsAlive cIsAlive = new CIsAlive();
        System.out.println("Begin :" + cIsAlive.isAlive());//FALSE
        cIsAlive.start();
        Thread.sleep(1000);
        System.out.println("END :" + cIsAlive.isAlive());//TRUE

    }


}
