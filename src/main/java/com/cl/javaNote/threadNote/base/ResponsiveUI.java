package com.cl.javaNote.threadNote.base;

/**
 * Created by cl on 2017/10/28.
 * 控制台用户界面
 *
 */

/**
 * 关注于运算，所以不能读取控制台输出
 */
class UnresponsiveUI {
    private volatile double d = 1;
    public UnresponsiveUI() throws Exception {
        while(d > 0)
            d = d + (Math.PI + Math.E) / d;
        System.in.read(); // Never gets here
    }
}

/**
 * 把运算放在任务里单独运行
 * 可以在进行运算的同时监控控制台输出
 */
public class ResponsiveUI extends Thread {
    private static volatile double d = 1;
    public ResponsiveUI() {
        setDaemon(true);
        start();
    }
    public void run() {
        while(true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }
    public static void main(String[] args) throws Exception {
        //! new UnresponsiveUI(); // Must kill this process
        new ResponsiveUI();
        System.in.read();
        System.out.println(d); // Shows progress
    }
} ///:~
