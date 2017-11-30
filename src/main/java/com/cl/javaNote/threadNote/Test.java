package com.cl.javaNote.threadNote;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/10/21.
 */
public class Test {
    Thread threadTest;

    public Test(Thread threadTest) {
        this.threadTest = threadTest;
    }

    void stop(){
        threadTest.interrupt();
        System.out.println("线程终止");
    }
    void start(){
        threadTest.start();
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new ThreadTest());
//        Test test = new Test(thread);
//        test.start();
//        TimeUnit.SECONDS.sleep(3);
//        test.stop();

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ThreadTest());
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdown();
        System.out.println("中断");
    }
}
class ThreadTest implements Runnable{

    public void run() {
        while (!Thread.interrupted()){
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("线程正在运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
