package com.cl.javaNote.threadNote.cooperation;

import com.cl.javaNote.threadNote.base.LiftOff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * Created by cl on 2017/8/10.
 * 同步队列：在任何时刻都只允许一个任务插入或移除元素
 * LinkedBlockingQueue/ArrayBlockingQueue
 */
public class TestBlockingQueues {
    static void getkey(){
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void getkey(String message){
        System.out.println(message);
        getkey();
    }

    static void test(String msg ,BlockingQueue<LiftOff> queue){
        System.out.println(msg);
        /*
            每个任务放置到BlockingQueue中，并且由LiftOffRunner从BlockingQueue取出
            BlockingQueue处理了所有的同步问题
         */
        LiftOffRunner liftOffRunner = new LiftOffRunner(queue);
        Thread  t = new Thread(liftOffRunner);
        t.start();
        for (int i = 0; i < 5; i++) {
            liftOffRunner.add(new LiftOff(5));
        }
        getkey("press 'enter' ("+msg+")");
        t.interrupt();
        System.out.println("finished "+msg+" test");
    }

    public static void main(String[] args) {
        test("ArrayBlockingQueue",new ArrayBlockingQueue<LiftOff>(3));
        test("SynchronousQueue",new SynchronousQueue<LiftOff>());
    }

}

class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
        this.rockets = rockets;
    }

    public void add(LiftOff liftOff) {
        try {
            rockets.put(liftOff);
        } catch (InterruptedException e) {
            System.out.println("add 中断！！");
        }
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {

                LiftOff liftOff = rockets.take();
                /*
                通过显式的调用run()而使用自己的线程来运行，而不是为每个任务启动一个新线程
                 */
                liftOff.run();
            }
        } catch (InterruptedException e) {
            System.out.println("working for take()");
        }
        System.out.println("exiting LiftOffRunner");
    }
}