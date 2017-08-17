package com.cl.javaNote.threadNote.resourceHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cl on 2017/8/9.
 * 同步控制块 : synchronized (Object){}
 * 作用：在进入此代码前，就必须先获取该对象的锁。如果其他线程已经得到了该对象的锁，那么就必须等到锁被释放以后
 * <p>
 * 下例详情：把一个非保护类型的类，在其他类的保护和控制之下，应用于多线程环境
 */
public class CriticalSection {
    static void testApproaches(PairManager parm1, PairManager parm2) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator pm1 = new PairManipulator(parm1), pm2 = new PairManipulator(parm2);
        PairChecker pc1 = new PairChecker(parm1), pc2 = new PairChecker(parm2);
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(pc1);
        executorService.execute(pc2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("pm1:" + pm1 + " pm2" + pm2);
        System.exit(0);
    }

    public static void main(String[] args) {
        PairManager pm1 = new PairManager1(), pm2 = new PairManager2();
        testApproaches(pm1, pm2);
    }
}

class Pair {
    private int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Pair() {
        this(0, 0);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incrementX() {
        x++;
    }

    public void incrementY() {
        y++;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public class PairValueNoEqualException extends RuntimeException {
        public PairValueNoEqualException() {
            super("pair 值不相等" + Pair.this);
        }
    }

    public void checkState() {
        if (x != y) {
            throw new PairValueNoEqualException();
        }
    }
}

abstract class PairManager {
    AtomicInteger checkCount = new AtomicInteger(0);
    protected Pair pair = new Pair();
    private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());

    public synchronized Pair getPair() {
        return new Pair(pair.getX(), pair.getY());
    }

    protected void store(Pair pair) {
        storage.add(pair);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void increment();
}

class PairManager1 extends PairManager {
    public synchronized void increment() {
        pair.incrementX();
        pair.incrementY();
        store(getPair());
    }
}

class PairManager2 extends PairManager {
    public synchronized void increment() {
        Pair temp;
        synchronized (this) {
            pair.incrementX();
            pair.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}

class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true)
            pm.increment();
    }

    @Override
    public String toString() {
        return "PairManipulator{" +
                "pm=" + pm.getPair() + "checkCounter=" + pm.checkCount.get() +
                '}';
    }
}

class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
        while (true) {
            pm.checkCount.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}