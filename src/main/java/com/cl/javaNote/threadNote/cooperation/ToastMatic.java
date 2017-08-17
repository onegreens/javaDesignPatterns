package com.cl.javaNote.threadNote.cooperation;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/10.
 * <p>
 * 实例：一台机器有三个任务：一个制作吐司，一个给吐司摸黄油，一个给抹过黄油的吐司涂果酱
 *
 *
 */
public class ToastMatic {
    public static void main(String[] args) throws InterruptedException {
        ToastQueue
                dryQueue =  new ToastQueue(),
                butteredQueue =  new ToastQueue(),
                finishedQueue =  new ToastQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Toaster(dryQueue));
        executorService.execute(new Butterer(dryQueue,butteredQueue));
        executorService.execute(new Jammer(butteredQueue,finishedQueue));
        executorService.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

/**
 * 吐司
 */
class Toast {
    public enum Status {DRY, BUTTERRD, JAMMED}//设置状态

    private Status status = Status.DRY;//定义初始状态
    private final int id;

    public Toast(int id) {
        this.id = id;
    }

    public void butter() {
        status = Status.BUTTERRD;
    }

    public void jamm() {
        status = Status.JAMMED;
    }

    public Status getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", id=" + id +
                '}';
    }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {
}

/**
 * 创造一个吐司，并将它添加到序列中
 */
class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random random = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));
                Toast toast = new Toast(count++);
                System.out.println(toast);
                toastQueue.put(toast);
            }
        } catch (InterruptedException e) {
            System.out.println("toastqueue interrupting ");
        }
        System.out.println("toast off");
    }
}

/**
 * 给吐司抹黄油，并将它添加到其他序列中
 */
class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();//由于取不到值，自然造成阻塞？？？亦或是队列为空时自然造成阻塞
                t.butter();
                System.out.println(t);
                butteredQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("butterer interrupt");
        }
        System.out.println("butter off");
    }
}

class Jammer implements Runnable {
    private ToastQueue finishedQueue, butteredQueue;

    public Jammer( ToastQueue butteredQueue,ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
        this.butteredQueue = butteredQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {

                Toast t = butteredQueue.take();
                t.jamm();
                System.out.println(t);
                finishedQueue.put(t);
            }
        } catch (InterruptedException e) {
            System.out.println("jammer interrupt");
        }
        System.out.println("jammer off");
    }
}

class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int count = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {

                Toast t = finishedQueue.take();
                if (t.getId() != count++ || t.getStatus() != Toast.Status.JAMMED){
                    System.out.println(">>>>> error :" + t);
                    System.exit(1);
                }
                System.out.println("chrom! == "+t);

            }
        } catch (InterruptedException e) {
            System.out.println("Eater interrupt");
        }
        System.out.println("Eater off");
    }
}


