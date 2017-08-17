package com.cl.javaNote.threadNote.unwantToGetAName;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cl on 2017/8/11.
 * <p>
 * 比较各类互斥技术
 */
public class SimpleBenchMiark {
    static long test(Incrementable incrementable){
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            incrementable.increment();
        }
        return System.nanoTime() - start;
    }

    public static void main(String[] args) {
        long synchTime = SimpleBenchMiark.test(new SynchroizedIncrement());
        long LOCKTime = SimpleBenchMiark.test(new LockIncrement());
        System.out.println(synchTime);
        System.out.println(LOCKTime);
        System.out.println(LOCKTime/synchTime);
    }
}

abstract class Incrementable {
    protected long counter = 0;

    abstract void increment();
}

class SynchroizedIncrement extends Incrementable {
    public synchronized void increment() {
        counter++;
    }
}

class LockIncrement extends Incrementable {
    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            counter++;
        } finally {
            lock.unlock();
        }
    }
}
