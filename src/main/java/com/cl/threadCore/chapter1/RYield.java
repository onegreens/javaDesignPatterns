package com.cl.threadCore.chapter1;

public class RYield extends Thread {
    public RYield(boolean flag) {
        this.flag = flag;
    }

    boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        int count = 0;
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            if (flag) {
                Thread.yield();
            }
            count += i;
        }
        if (flag)
            System.out.println("切换用时:" + (System.currentTimeMillis() - beginTime));
        else
            System.out.println("用时:" + (System.currentTimeMillis() - beginTime));
    }

    public static void main(String[] args) {
        RYield thread1 = new RYield(true);
        RYield thread2 = new RYield(false);
        thread1.start();
        thread2.start();
    }
}
