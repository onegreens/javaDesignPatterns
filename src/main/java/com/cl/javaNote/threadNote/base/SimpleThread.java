package com.cl.javaNote.threadNote.base;

/**
 * Created by cl on 2017/8/7.
 * 继承Thread
 */
public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadcount = 0;

    public SimpleThread() {
        super(Integer.toString(++threadcount));
        start();
    }

    @Override
    public String toString() {
        return "SimpleThread{" +getName()+
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
            new SimpleThread();
        }
    }

}
