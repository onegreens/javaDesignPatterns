package com.cl.javaNote.threadNote.newUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/11.
 * <p>
 * Semaphore : 计数信号量
 * <p>
 * 正常的锁在任何时刻都只允许一个任务访问一项资源，而计数信号量却允许n个任务同时访问这个资源
 */
public class SemaphoreDemo {
    private static int size = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> fatPool = new Pool<Fat>(Fat.class, size);

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < size; i++) {
            executorService.execute(new CheckoutTask<Fat>(fatPool));
        }
        System.out.println("all CheckoutTask create !!! ===============");

        List<Fat> fats = new ArrayList<Fat>();
        for (int i = 0; i < size; i++) {
            Fat f = fatPool.checkOut();
            System.out.println(i + " : main()  thread checked out ");
            f.operation();
            fats.add(f);
        }

        Future<?> blocked = executorService.submit(new Runnable() {
            public void run() {
                try {
                    fatPool.checkOut();
                } catch (InterruptedException e) {
                    System.out.println(" Future<?> blocked interrupting ");
                }
            }
        });
        TimeUnit.SECONDS.sleep(1);
        blocked.cancel(true);
        System.out.println("checking in list");
        for (Fat fat : fats) {
            fatPool.checkIn(fat);
        }
        for (Fat fat : fats) {
            fatPool.checkIn(fat);
        }
        executorService.shutdown();
    }
}

/**
 * 一个创建费时的类
 */
class Fat {
    private volatile double d = 0.0;
    private static int count = 0;
    private final int id = count++;

    public Fat() {
        for (int i = 0; i < 10000; i++) {
            d = (Math.PI + Math.E) / (double) i;
        }
    }

    public void operation() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat{" +
                "d=" + d +
                ", id=" + id +
                '}';
    }
}

/**
 * 执行签入签出操作
 *
 * @param <T>
 */
class CheckoutTask<T> implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + " checkout " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + " check in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            System.out.println("中断了 CheckoutTask");
        }
    }

    @Override
    public String toString() {
        return "CheckoutTask{" +
                "id=" + id +
                '}';
    }
}
