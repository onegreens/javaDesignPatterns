package com.cl.threadCore.chapter2.section1;

/**
 * 类私有变量会出现非线程安全
 */
public class HasPrivateNum extends Thread {
    int num = 0;
    public void addI(String username) {
        try {
            if (username.equals("a")) {
                num = 100;
                Thread.sleep(2000);

                System.out.println("it is a");
            } else {
                num = 200;
                System.out.println("it is b");
            }
            System.out.println(username + "  num is " + num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HasPrivateNum hasPrivateNum = new HasPrivateNum();
        HPThread threada = new HPThread("a", hasPrivateNum);
        HPThread threadb = new HPThread("b", hasPrivateNum);
        threada.start();
        threadb.start();
        /**

         it is b
         b  num is 200
         it is a
         a  num is 200

         */
    }
}

class HPThread extends Thread {
    public HPThread(String username, HasPrivateNum hasPrivateNum) {
        this.username = username;
        this.hasPrivateNum = hasPrivateNum;
    }

    String username;
    HasPrivateNum hasPrivateNum;

    @Override
    public void run() {
        hasPrivateNum.addI(username);

    }
}

