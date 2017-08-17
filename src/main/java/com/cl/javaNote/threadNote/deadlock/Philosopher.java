package com.cl.javaNote.threadNote.deadlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/11.
 * 创建一个筷子使用造成死锁的线程
 */
public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);

    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) return;
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
    }

    public void run() {

        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking ");
                pause();
                System.out.println(this + " grabbing left");
                left.take();
                pause();
                System.out.println(this + " grabbing right");
                right.take();
                System.out.println(this + " eating");
                pause();
                left.drop();
                right.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + " 中断！！！");
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
