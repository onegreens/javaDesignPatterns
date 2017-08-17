package com.cl.javaNote.threadNote.resourceHandler;

/**
 * Created by cl on 2017/8/8.
 * 使用synchronized
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;
    public synchronized int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
