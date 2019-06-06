package com.cl.threadCore.chapter2.section1;

/**
 * 同步不能继承
 */
public class SynNoExtends extends Thread{
    SNESub sub;

    public SynNoExtends(SNESub sub) {
        this.sub = sub;
    }

    @Override
    public void run() {
        sub.serviceMethod();
    }

    public static void main(String[] args) {
        SNESub sneSub = new SNESub();
        SynNoExtends threadA = new SynNoExtends(sneSub);
        threadA.setName("A");
        threadA.start();
        SynNoExtends threadB = new SynNoExtends(sneSub);
        threadB.setName("B");
        threadB.start();
        /**
         *
         子类不同步
         A begin SNESub time 1559803562523
         B begin SNESub time 1559803562523
         A end SNESub time 1559803563523
         B end SNESub time 1559803563523
         A begin SNEMain time 1559803563523
         A end SNEMain time 1559803564524
         B begin SNEMain time 1559803564524
         B end SNEMain time 1559803565524

         子类同步
         A begin SNESub time 1559803597895
         A end SNESub time 1559803598895
         A begin SNEMain time 1559803598895
         A end SNEMain time 1559803599895
         B begin SNESub time 1559803599895
         B end SNESub time 1559803600895
         B begin SNEMain time 1559803600895
         B end SNEMain time 1559803601896
         */
    }
}

class SNEMain {
    synchronized void serviceMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin SNEMain time " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end SNEMain time " + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SNESub extends SNEMain {
    synchronized void serviceMethod() {
//    void serviceMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + " begin SNESub time " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " end SNESub time " + System.currentTimeMillis());
            super.serviceMethod();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
