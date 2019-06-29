package com.cl.threadCore.chapter2.section1;

/**
 * 证明synchronized锁的是对象
 * <p>
 * 访问同一个对象的同步或非同步方法
 */
public class SynchronizedMethodLockObject {
    synchronized public void methodA() {        //测试同步方法
//    public void methodA() {        //测试非同步方法

        try {
            System.out.println("begin methodA name : " + Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.println("end methodA name : " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynchronizedMethodLockObject object = new SynchronizedMethodLockObject();
        SMLOThread threada = new SMLOThread(object);
        threada.setName("threada");
        threada.start();
        SMLOThread threadb = new SMLOThread(object);
        threadb.setName("threadb");
        threadb.start();
        /**
         * 非同步
         begin methodA name : threadb
         begin methodA name : threada
         end methodA name : threada
         end methodA name : threadb

         同步
         begin methodA name : threada
         end methodA name : threada
         begin methodA name : threadb
         end methodA name : threadb
         */
    }
}

class SMLOThread extends Thread {
    public SMLOThread(SynchronizedMethodLockObject synchronizedMethodLockObject) {
        this.synchronizedMethodLockObject = synchronizedMethodLockObject;
    }

    SynchronizedMethodLockObject synchronizedMethodLockObject;

    @Override
    public void run() {
        synchronizedMethodLockObject.methodA();
    }
}
