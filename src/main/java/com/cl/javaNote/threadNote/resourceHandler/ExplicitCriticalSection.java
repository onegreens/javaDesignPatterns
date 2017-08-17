package com.cl.javaNote.threadNote.resourceHandler;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cl on 2017/8/9.
 * 显示lock创建临界区 等同于synchronized同步块
 */
public class ExplicitCriticalSection {
    public static void main(String[] args) {
        PairManager p1 = new ExplicitPairManager1(),
                p2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(p1, p2);
    }

}

class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    public synchronized void increment() {
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    public void increment() {
        Pair temp;
        lock.lock();
        try {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}

