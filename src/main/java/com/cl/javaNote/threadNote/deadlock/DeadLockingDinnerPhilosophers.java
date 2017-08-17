package com.cl.javaNote.threadNote.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/11.
 * 制造筷子死锁实例测试 main1
 *
 * 解决死锁问题 main
 */
public class DeadLockingDinnerPhilosophers {
    public static void main1(String[] args) throws InterruptedException {
        int ponder = 5;
        int size = 5;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            executorService.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)%size],i,ponder));
        }
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();

    }

    public static void main(String[] args) throws InterruptedException {
        int ponder = 5;
        int size = 5;
        ExecutorService executorService = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            if ( i < size -1 ){
                executorService.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)],i,ponder));
            }else {
                executorService.execute(new Philosopher(chopsticks[0],chopsticks[i],i,ponder));
            }
        }
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}
