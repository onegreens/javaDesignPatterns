package com.cl.javaNote.threadNote.cooperation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/10.
 *
 * 实例说明：汽车涂蜡与抛光，抛光必须在涂蜡进行之后
 */
public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new WaxOn(car));
        executorService.execute(new WaxOff(car));

        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Car {
    private boolean waxOn = false;//主要控制属性

    public synchronized void waxed() {
        waxOn = true;
        notify();
    }

    public synchronized void buffed() {
        waxOn = false;
        notify();
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        while (waxOn == false)
            wait();
    }

    public synchronized void waitingForBuffing() throws InterruptedException {
        while (waxOn == true)
            wait();
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
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
            System.out.println("中断了");
        }
        System.out.println("end of waxon on task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
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
            System.out.println("中断了");
        }
        System.out.println("end of WaxOff on task");
    }
}
