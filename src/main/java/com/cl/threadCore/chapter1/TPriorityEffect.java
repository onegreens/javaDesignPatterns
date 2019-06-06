package com.cl.threadCore.chapter1;

import java.util.Random;

/**
 * 优先级的作用
 *
 * 优先级和执行顺序无关
 *
 * 优先级高的相对先执行完  但是具有随机性
 */
public class TPriorityEffect extends Thread {
    private String name;

    public TPriorityEffect(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        int count = 0;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10000; j++) {
                Random random = new Random();
                random.nextInt();
                count += i;
            }
            System.out.println("---- " + name + " run time " + (System.currentTimeMillis() - begin));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            TPriorityEffect thread1 = new TPriorityEffect("thread1");
            thread1.setPriority(10);
            thread1.start();
            TPriorityEffect thread2 = new TPriorityEffect("thread2");
            thread2.setPriority(1);
            thread2.start();
        }

        Thread.sleep(2000);
        System.out.println("");
        System.out.println("");
        System.out.println("");
        //优先级和执行顺序无关

        for (int i = 0; i < 5; i++) {
            TPriorityEffect thread3 = new TPriorityEffect("thread3");
            thread3.setPriority(1);
            thread3.start();
            TPriorityEffect thread4 = new TPriorityEffect("thread4");
            thread4.setPriority(10);
            thread4.start();
        }
    }
}
