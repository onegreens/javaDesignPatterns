package com.cl.javaNote.threadNote.deadlock;

/**
 * Created by cl on 2017/8/11.
 * 筷子 用于筷子实例
 */
public class Chopstick {
    public boolean taken = false;
    public synchronized void take() throws InterruptedException {
        while (taken)
            wait();
        taken = true;
    }

    public synchronized void drop(){
        taken = false;
        notifyAll();
    }

}
