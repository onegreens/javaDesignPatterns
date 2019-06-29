package com.cl.threadCore.chapter2.section1;

/**
 * 线程出现异常会释放锁
 */
public class ThrowExceptionNoLock {
    synchronized void testMethod() {
        if (Thread.currentThread().getName().equals("A")) {
            System.out.println(" Thread " + Thread.currentThread().getName() + " begin :" + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if ((Math.random() + "").substring(0, 8).equals("0.123456")) {
                    System.out.println(" Thread " + Thread.currentThread().getName() + " exception :" + System.currentTimeMillis());
                    Integer.parseInt("A");

                }
            }
        } else {
            System.out.println(" Thread " + Thread.currentThread().getName() + " run :" + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) {
        ThrowExceptionNoLock lock = new ThrowExceptionNoLock();
        TENLThread threadA = new TENLThread(lock);
        threadA.setName("A");
        threadA.start();
        TENLThread threadB = new TENLThread(lock);
        threadB.setName("B");
        threadB.start();
        /**
         Thread A begin :1559802476800
         Exception in thread "A" java.lang.NumberFormatException: For input string: "A"
         Thread A exception :1559802477131
         Thread B run :1559802477132
         */

    }
}

class TENLThread extends Thread {
    public TENLThread(ThrowExceptionNoLock object) {
        this.object = object;
    }

    ThrowExceptionNoLock object;

    @Override
    public void run() {
        object.testMethod();
    }
}
