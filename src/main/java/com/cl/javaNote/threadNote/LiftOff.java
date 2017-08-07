package com.cl.javaNote.threadNote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by cl on 2017/8/7.
 *
 * 简单的线程任务
 *
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "( " + (countDown > 0 ? countDown : "Liftoff") + " )";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();//线程调度器（线程转换）
        }

    }

    /**
     * 无线程
     * @param args
     */
    public static void main1(String[] args) {
        LiftOff liftOff = new LiftOff();
        liftOff.run();
    }

    /**
     * 单个线程
     * @param args
     */
    public static void main2(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("wait for liftoff");
    }

    /**
     * 多个线程
     * @param args
     */
    public static void main3(String[] args) {
        for (int i = 0; i < 5; i++) {
           new Thread(new LiftOff()).start();
        }
        System.out.println("wait for liftoff");
    }

    /**
     * 使用executor执行器管理thread对象，简化并发编程
     *
     * Executor在客户端和任务执行之间提供了间接层，允许管理异步任务的执行，而无需显示地管理线程的生命周期
     *
     * shutdown()方法可以防止新任务被提交给这个executor
     * @param args
     */
    public static void main4(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

    /**
     * FixedThreadPool 可以一次性预先执行线程分配，控制线程数量
     * @param args
     */
    public static void main5(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 9; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }

    /**
     * SingThreadExecutor 线程数量为1的FixedThreadPool
     * 确保任意时刻中都要只有一个唯一的任务在运行
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 9; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
