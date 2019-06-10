package com.cl.threadCore.chapter2.section2;

import org.apache.poi.ss.formula.functions.T;

public class AsyncAndSync extends Thread{
    ASTask task;

    public AsyncAndSync(ASTask task) {
        this.task = task;
    }
    @Override
    public void run() {
        task.doLongTimeTask();
    }

    public static void main(String[] args) {
        ASTask task = new ASTask();
        AsyncAndSync thread1 = new AsyncAndSync(task);
        thread1.start();
        AsyncAndSync thread2 = new AsyncAndSync(task);
        thread2.start();
    }
}
class ASTask{
    public void doLongTimeTask(){
        for (int i = 0; i < 100; i++) {
            System.out.println("no synchronized thread name = "+Thread.currentThread().getName()+" i = "+i);
        }
        System.out.println("");
        synchronized (this){
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized thread name = "+Thread.currentThread().getName()+" i = "+i);
            }
        }
    }
}
