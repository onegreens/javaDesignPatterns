package com.work.zip;

import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/10/20.
 */
public class Test implements Runnable {
    static int i = 0;
    static int j = 0;

    public void run() {
        while (true) {
            try {
                System.out.println("i= " + i);
                if (i == 0) {
                    System.out.println("test1正在运行！！！");
                } else {
                    System.out.println("暂停运行");
                }

                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main1(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Test());
        thread1.start();
        //获取线程ID
        long id=thread1.getId();
        //获取线程名称
        String name=thread1.getName();
        //获取线程级别
        int  priority =thread1.getPriority();
        //获取线程状态
        Thread.State state=thread1.getState();
        System.out.println("id is:"+id);
        System.out.println("name is:"+name);
        System.out.println("priority is:"+priority);
        System.out.println("state is:"+state);


    }

    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        while (i == 1){
            TimeUnit.MILLISECONDS.sleep(50);

            System.out.println("循环");
        }
        TimeUnit.SECONDS.sleep(1);
        i= 2;
        System.out.println("终止");
    }
}
