package com.cl.javaNote.threadNote.base;

/**
 * Created by cl on 2017/8/7.
 * 继承Thread
 *
 * start()是在构造方法中调用的
 * 可能存在的问题：另一个任务可能会在构造器结束之前开始执行，这意味着该任务能够访问处于不稳定的状态
 */
public class SelfManage extends Thread {
    private int countDown = 5;
    private Thread thread = new Thread(this);

    public SelfManage() {
        thread.start();
    }

    @Override
    public String toString() {
        return "SelfManage{" +Thread.currentThread().getName()+
                " countDown=" + countDown +
                '}';
    }

    public void run(){
        while (countDown-- > 0) {
            System.out.println(this);
            if (-- countDown == 0)
                return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManage();
        }
    }

}
