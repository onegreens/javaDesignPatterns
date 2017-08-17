package com.cl.javaNote.threadNote.cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cl on 2017/8/10.
 * <p>
 * 实例说明：汽车涂蜡与抛光，抛光必须在涂蜡进行之后
 *
 * 使用显示的Lock和Condition对象
 *
 * try-finally ：用来保证所有情况下都可以释放锁
 *
 * 三个关键方法：await(),signal(),signalAll()
 */
public class WaxOMatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car2 car2 = new Car2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOn2(car2));
        executorService.execute(new WaxOff2(car2));

        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Car2 {
    private boolean waxOn = false;//主要控制属性
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public synchronized void waxed() {
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public synchronized void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false)
                condition.await();
        } finally {
            lock.unlock();
        }
    }

    public synchronized void waitingForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true)
                condition.await();
        } finally {
            lock.unlock();
        }
    }
}

class WaxOn2 implements Runnable {
    private Car2 car;

    public WaxOn2(Car2 car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("wax on !!!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitingForBuffing();
            }

        } catch (InterruptedException e) {
            System.out.println("WaxOn2 中断了");
        }
        System.out.println("end of WaxOn2 on task");
    }
}

class WaxOff2 implements Runnable {
    private Car2 car;

    public WaxOff2(Car2 car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForWaxing();
                System.out.println("wax Off !!!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("WaxOff2 中断了");
        }
        System.out.println("end of WaxOff2 on task");
    }
}

