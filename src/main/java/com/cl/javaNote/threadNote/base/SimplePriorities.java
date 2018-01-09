package com.cl.javaNote.threadNote.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cl on 2017/8/7.
 * 优先级：将该线程的重要性传递给调度器，调度器将倾向于让优先权最高的线程先执行，使得其执行的频率增加
 *
 */
public class SimplePriorities implements Runnable {
    private int countdown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SimplePriorities{"+priority+"} " + Thread.currentThread() + ": " + countdown;
    }

    public void run() {
        //设置当前线程优先级
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 0; i < 10000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (1 % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (countdown-- == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        executorService.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        executorService.shutdown();
    }
}
