package com.cl.javaNote.threadNote.base;

/**
 * Created by cl on 2017/8/8.
 * 一个线程可以在其他线程上调用join方法，其效果是等待一段时间直到第二个线程结束才继续执行。
 * 如果某个线程在另一个线程t上调用t.join(),此线程将被挂起，直到目标线程结束之后才恢复
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleeper = new Sleeper("sleeper", 1500),
                grumpy = new Sleeper("grumpy", 1500);
        Joiner
                joiner = new Joiner("joiner", sleeper),
                join = new Joiner("join", grumpy);
//        grumpy.interrupt();
    }
}

class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int duration) {
        super(name);
        this.duration = duration;
        start();
    }

    public void run() {
        try {
            System.out.println(getName() + "启动 Sleeper" + "isInterrupted" + isInterrupted());
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + "运行中断 Sleeper" + "isInterrupted" + isInterrupted());
            return;
        }
        System.out.println(getName() + "恢复");
    }
}

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            System.out.println(sleeper.getName() + "进行加入线程"+this.getName() );
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println(getName() + "运行中断 Sleeper" + "isInterrupted" + isInterrupted());
            return;
        }
        System.out.println(this.getName() + "加入线程"+sleeper.getName());
    }

}
