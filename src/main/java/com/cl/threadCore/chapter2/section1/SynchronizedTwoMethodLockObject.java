package com.cl.threadCore.chapter2.section1;

/**两个对象访问一个对象的不同方法
 */
public class SynchronizedTwoMethodLockObject {

    synchronized public void methodA() {

        try {
            System.out.println("begin methodA name : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end methodA name : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {        //测试同步方法
//    public void methodB() {        //测试非同步方法

        try {
            System.out.println("begin methodB name : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end methodB name : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedTwoMethodLockObject object = new SynchronizedTwoMethodLockObject();
        STMLOThreadA threada = new STMLOThreadA(object);
        threada.setName("threada");
        threada.start();
        STMLOThreadB threadb = new STMLOThreadB(object);
        threadb.setName("threadb");
        threadb.start();
        /**
         * 非同步
         begin methodA name : threada
         begin methodB name : threadb
         end methodA name : threada
         end methodB name : threadb

         同步
         begin methodA name : threada
         end methodA name : threada
         begin methodB name : threadb
         end methodB name : threadb
         */
    }
}

class STMLOThreadA extends Thread {
    public STMLOThreadA(SynchronizedTwoMethodLockObject synchronizedMethodLockObject) {
        this.synchronizedMethodLockObject = synchronizedMethodLockObject;
    }

    SynchronizedTwoMethodLockObject synchronizedMethodLockObject;

    @Override
    public void run() {
        synchronizedMethodLockObject.methodA();
    }
}

class STMLOThreadB extends Thread {
    public STMLOThreadB(SynchronizedTwoMethodLockObject synchronizedMethodLockObject) {
        this.synchronizedMethodLockObject = synchronizedMethodLockObject;
    }

    SynchronizedTwoMethodLockObject synchronizedMethodLockObject;

    @Override
    public void run() {
        synchronizedMethodLockObject.methodB();
    }
}
