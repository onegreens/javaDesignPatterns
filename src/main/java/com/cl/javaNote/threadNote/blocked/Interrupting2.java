package com.cl.javaNote.threadNote.blocked;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cl on 2017/8/10.
 * 在Reentrantlock上阻塞的任务具有被中断的能力
 *
 *
 */
public class Interrupting2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked2());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Issuing t.interrupting");
        t.interrupt();//大胆被互斥所阻塞的调用
    }
}
class BlockedMutex{
    private Lock lock = new ReentrantLock();

    public BlockedMutex() {
        lock.lock();//获取自身上的锁
    }
    public void f(){
        try {
            lock.lockInterruptibly();
            System.out.println("lock acquire for f()");
        } catch (InterruptedException e) {
            System.out.println("interrupting for f()");
        }
    }
}

class Blocked2 implements Runnable{
private BlockedMutex blockedMutex = new BlockedMutex();
    public void run() {
        System.out.println("wait for f() in BlockedMutex ");
        blockedMutex.f();
        System.out.println("broken out for blocked call");
    }
}
