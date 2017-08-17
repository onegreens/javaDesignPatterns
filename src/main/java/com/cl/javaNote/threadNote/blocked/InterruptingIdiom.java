package com.cl.javaNote.threadNote.blocked;

import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/10.
 * 检查中断
 * <p>
 * 中断状态，通过interrupt()来设置。可通过interrupted()来检测
 * interrupted()作用：判断interrupt()是否被调用过，清除中断状态
 * <p>
 * 清除中断状态可以确保并发结构不会就某个人物被终端这个问题通知两次
 * 可通过InterruptedException或单一的成功的Thread.interrupted()测试得到这种通知
 * <p>
 * 实例：处理在中断状态被设置时，被阻塞或不被阻塞的各种可能
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        if (args.length!=1){
            System.out.println("参数错误");
            System.exit(1);
        }
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
        t.interrupt();

    }
}

/**
 * 强调经由异常离开循环时，正确清理资源的必要性
 */
class NeedsCleanup {
    private final int id;

    public NeedsCleanup(int id) {
        this.id = id;
        System.out.println("NeedsCleanup id = " + id);
    }

    public void cleanup() {
        System.out.println("clean up id = " + id);
    }
}

class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedsCleanup n1 = new NeedsCleanup(1);
                try {
                    System.out.println("sleeping");
                    TimeUnit.SECONDS.sleep(1);
                    NeedsCleanup n2 = new NeedsCleanup(2);
                    try {
                        System.out.println("calculating");
                        for (int i = 0; i < 2500000; i++) {
                            d = d + (Math.E + Math.PI) / d;
                        }
                        System.out.println("finish time consuming operating");

                    } finally {//确保资源清理
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("exiting via while() test");
        } catch (InterruptedException e) {
            System.out.println("exiting via interruptedException");
        }

    }
}
