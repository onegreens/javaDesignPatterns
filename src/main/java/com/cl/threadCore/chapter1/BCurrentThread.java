package com.cl.threadCore.chapter1;

/**
 * currentThread 显示代码正在被那个片段调用
 */
public class BCurrentThread extends Thread{
    public BCurrentThread() {
        System.out.println("CountOperate begin");
        System.out.println("CountOperate thread name:" + Thread.currentThread().getName());
        System.out.println("CountOperate name:" + this.getName());
        System.out.println("CountOperate end");
    }

    @Override
    public void run() {
        System.out.println("run begin");
        System.out.println("run thread name:" + Thread.currentThread().getName());
        System.out.println("run name:" + this.getName());
        System.out.println("run end");
    }


    public static void main(String[] args) {
        BCurrentThread countOperate = new BCurrentThread();
        Thread thread = new Thread(countOperate, "A");
        thread.start();
    }
}
