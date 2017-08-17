package com.cl.javaNote.threadNote.resourceHandler;

/**
 * Created by cl on 2017/8/9.
 * 在其他对象上同步
 *
 *
 */
public class SyncObject {
    public static void main(String[] args) {
        final DualSuynch ds = new DualSuynch();

        new Thread(){
            public void run(){
                ds.f();
            }
        }.start();
        ds.g();
        ds.g();
    }
}

class DualSuynch{
    private Object syncObject = new Object();
    public synchronized void f(){
        for (int i = 0; i < 5; i++) {
            System.out.println("f()");
            Thread.yield();
        }
    }
    public void g(){
        synchronized (syncObject){
            for (int i = 0; i < 5; i++) {
                System.out.println("g()");
                Thread.yield();
            }
        }
    }
}
