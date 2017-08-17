package com.cl.javaNote.threadNote.newUtil;

/**
 * Created by cl on 2017/8/11.
 *
 * countDownLatch ：用来同步一个或多个任务，强制它们等待由其他任务执行的一组操作完成
 *
 * 典型用法：
 *      将一个程序分为n个相互独立的可解决任务，并创建值为0的CountDownLatch。当每个任务完成时，都会在这个锁存器上调用countDown()。
 *      等待问题被解决的任务在这个锁存器上调用await()，将他们自己拦住，直到锁存器计数结束
 *
 */
public class CountDownLatchDemo {
}
