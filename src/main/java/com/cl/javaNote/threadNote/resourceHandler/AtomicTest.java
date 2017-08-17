package com.cl.javaNote.threadNote.resourceHandler;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by cl on 2017/8/8.
 *
 * 原子类：AtomicInteger / AtomicLong / AtomicReference
 *
 * 局限：Atomic被设计用来构建concurrent中类，因此只有特殊情况下才在自己的代码中使用它们，并不能确保不出现问题
 */
public class AtomicTest implements Runnable{
    private AtomicInteger i  = new AtomicInteger(0);
    private Integer getValue (){
        return i.get();
    }
    private void evenIncrement(){
        i.addAndGet(2);
    }

    public void run() {
        while (true)
            evenIncrement();
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicTest atomicTest = new AtomicTest();
        executorService.execute(atomicTest);
        while (true){
            int val = atomicTest.getValue();
            if (val% 2 !=0){
                System.err.println(val);
                System.exit(0);
            }
        }
    }
}
