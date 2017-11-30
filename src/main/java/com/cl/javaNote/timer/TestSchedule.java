package com.cl.javaNote.timer;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/10/20.
 */
public class TestSchedule {
    long time_long = 0;
    long time_long1 = 0;
    Timer timer;
    Timer timer1;

    void test(int sec) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                long currnt = System.currentTimeMillis();
                System.out.println("schedule:"+currnt);
                time_long1 = currnt;
            }
        }, sec * 1000, sec * 2000);
    }

    void test2(int sec) {
        timer1 = new Timer();
        timer1.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                long currnt = System.currentTimeMillis();
                System.out.println("scheduleAtFixedRate："+currnt);
                time_long = currnt;
            }
        }, sec * 1000, sec * 2000);
    }

    public static void main(String[] args) {
        new TestSchedule().test(2);
//        new TestSchedule().test2(2);
    }
}
