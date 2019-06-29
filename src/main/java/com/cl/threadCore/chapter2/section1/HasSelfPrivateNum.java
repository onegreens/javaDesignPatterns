package com.cl.threadCore.chapter2.section1;

/**
 * 方法私有变量不会出现非线程安全
 */
public class HasSelfPrivateNum extends Thread {
    public void addI(String username) {
        try {
            int num = 0;
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
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        HThread threada = new HThread("a", hasSelfPrivateNum);
        HThread threadb = new HThread("b", hasSelfPrivateNum);
        threada.start();
        threadb.start();
        /**

         it is b
         b  num is 200
         it is a
         a  num is 100

         */
    }
}

class HThread extends Thread {
    public HThread(String username, HasSelfPrivateNum hasSelfPrivateNum) {
        this.username = username;
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    String username;
    HasSelfPrivateNum hasSelfPrivateNum;

    @Override
    public void run() {
        hasSelfPrivateNum.addI(username);

    }
}

