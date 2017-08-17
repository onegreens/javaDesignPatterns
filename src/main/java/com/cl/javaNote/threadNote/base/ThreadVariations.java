package com.cl.javaNote.threadNote.base;

import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/8.
 * 通过内部类将线程代码隐藏
 *
 * InnerThread1 :创建了一个宽展字Thread的匿名内部类，并在构造方法中创建了他的实例
 * InnerThread2 ：相对于1展示了可替换的方法，在构造器中创建了一个匿名的Thread的子类，并将其向上转性为Thread，其他方法可通过调用t
 * InnerRunnable1，InnerRunnable2：改用接口Runnable方法
 * ThreadMethod ：展示在方法内部创建线程
 *
 */
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runtask();
    }
}

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("运行中断 thread1");
            }
        }

        @Override
        public String toString() {
            return getName() + " " + countDown;
        }
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("运行中断 thread2");
                }
            }

            @Override
            public String toString() {
                return getName() + " " + countDown;
            }
        };
        t.start();

    }
}

class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        public Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("运行中断 InnerRunnable1");
            }
        }

        @Override
        public String toString() {
            return t.getName() + " " + countDown;
        }
    }
}

class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        TimeUnit.MILLISECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("运行中断 InnerRunnable2");
                }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName() + " " + countDown;
            }
        }, name);
        t.start();
    }
}

class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runtask() {
        t = new Thread(name) {
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        sleep(20);
                    }
                } catch (InterruptedException e) {
                    System.out.println("运行中断 ThreadMethod");
                }
            }

            @Override
            public String toString() {
                return getName() + " " + countDown;
            }
        };
        t.start();
    }
}




