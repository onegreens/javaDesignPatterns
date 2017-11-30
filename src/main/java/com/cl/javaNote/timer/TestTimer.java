package com.cl.javaNote.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by cl on 2017/10/20.
 * Timer是jdk中提供的一个定时器工具，使用的时候会在主线程之外起一个单独的线程执行指定的计划任务，可以指定执行一次或者反复执行多次。
 * 　TimerTask是一个实现了Runnable接口的抽象类，代表一个可以被Timer执行的任务。
 */
public class TestTimer {
    Timer timer;

    void test(int sec) {
        timer = new Timer();
        timer.schedule(new TimerTask() {

            public void run() {
                System.out.println(System.currentTimeMillis());
                System.out.println("定时任务启动");
                timer.cancel();//终止线程
            }
        }, sec * 1000);
    }

    public static void main(String[] args) {
        new TestTimer().test(2);
    }
}


