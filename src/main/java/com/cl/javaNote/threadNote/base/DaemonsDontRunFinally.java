package com.cl.javaNote.threadNote.base;

import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/7.
 * setDaemon对finally的影响
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);//会影响finally的执行
        t.start();
    }
}
class ADaemon implements Runnable{
    public void run() {
        try {
            System.out.println("adAEMON STARTING");
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println("zaishi pao?");
        }
    }
}