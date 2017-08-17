package com.cl.javaNote.threadNote.resourceHandler;

/*
原子操作：不能为线程调度机制中断的操作


1. 如果一个域可能会被多个任务同时访问，或者这个任务中至少有一个是写入任务，那么应该将这个域设置为volatile
2. 如果将一个域设置为volatile，那么编译器不会执行任何移除读取和写入操作的优化
    这些操作的目的是用线程中的局部变量维护对这个域的精准同步
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/8.
 */
public class SerialNumberChecker {
    private static final int size = 10;
    private static Circularset circularset = new Circularset(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 确保序列数是唯一的
     */
    static class SerialChecker implements Runnable {

        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (circularset.contains(serial)) {
                    System.out.println("duplicate " + serial);
                    System.exit(0);
                }
                circularset.add(serial);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < size; i++) {
            executorService.execute(new SerialChecker());
        }
        TimeUnit.SECONDS.sleep(4);
        System.out.println("no");
        System.exit(0);
    }
}

class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }
}

/**
 * 持有所产生的所有序列书
 */
class Circularset {
    private int array[];
    private int len;
    private int index = 0;

    public Circularset(int size) {
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val)
                return true;
        }
        return false;
    }

}