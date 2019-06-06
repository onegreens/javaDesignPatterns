package com.cl.threadCore.chapter2.section1;

/**
 * synchronized是针对对象的
 *
 * 多个对象访问同一个对象才会生效
 */
public class TwoObjectTwoLock {
    public static void main(String[] args) {
        TOTLObject totlObjecta = new TOTLObject();
        TOTLObject totlObjectb = new TOTLObject();
        TOTLThread threada = new TOTLThread("a", totlObjecta);
        TOTLThread threadb = new TOTLThread("b", totlObjectb);
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

class TOTLObject extends Thread {
    int num = 0;

    public synchronized void addI(String username) {
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
}

class TOTLThread extends Thread {
    public TOTLThread(String username, TOTLObject totlObject) {
        this.username = username;
        this.totlObject = totlObject;
    }

    String username;
    TOTLObject totlObject;

    @Override
    public void run() {
        totlObject.addI(username);

    }
}