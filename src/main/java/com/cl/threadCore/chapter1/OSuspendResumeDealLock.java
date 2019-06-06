package com.cl.threadCore.chapter1;

/**
 * suspend使用不当会造成公共同步对象独占,是其他线程无法访问公共同步对象
 */
public class OSuspendResumeDealLock {
    synchronized void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("A")) {
            System.out.println("a 线程 suspend 了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        try {
            final OSuspendResumeDealLock obj = new OSuspendResumeDealLock();
            Thread thread1 = new Thread() {
                @Override
                public void run() {

                    obj.printString();
                }
            };
            thread1.setName("A");
            thread1.start();

            Thread.sleep(1000);
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("进入不了 obj 因为被A线程锁定并suspend暂停了");
                    obj.printString();
                }
            };
            thread2.setName("B");
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
