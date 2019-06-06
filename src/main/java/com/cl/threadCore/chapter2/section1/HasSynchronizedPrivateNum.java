package com.cl.threadCore.chapter2.section1;

/**
 * 通过synchronized同步方法
 */
public class HasSynchronizedPrivateNum extends Thread {
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

    public static void main(String[] args) {
        HasSynchronizedPrivateNum hasSynchronizedPrivateNum = new HasSynchronizedPrivateNum();
        HSPThread threada = new HSPThread("a", hasSynchronizedPrivateNum);
        HSPThread threadb = new HSPThread("b", hasSynchronizedPrivateNum);
        threada.start();
        threadb.start();
        /**

         it is a
         a  num is 100
         it is b
         b  num is 200

         */
    }

}

class HSPThread extends Thread {
    public HSPThread(String username, HasSynchronizedPrivateNum hasSynchronizedPrivateNum) {
        this.username = username;
        this.hasSynchronizedPrivateNum = hasSynchronizedPrivateNum;
    }

    String username;
    HasSynchronizedPrivateNum hasSynchronizedPrivateNum;

    @Override
    public void run() {
        hasSynchronizedPrivateNum.addI(username);

    }
}
