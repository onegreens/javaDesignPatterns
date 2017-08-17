package com.cl.javaNote.threadNote.cooperation;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/11.
 * <p>
 * 任务使用管道进行输入、输出
 * 主要应用类：PipedWriter(允许任务向管道写)/PipedReader(允许不同任务同一个管道读)
 *
 * PipedReader和普通I/O之间的最重要的差异是 ---- PipedReader是可中断的
 */
public class PipedIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(sender);
        executorService.execute(receiver);
        TimeUnit.SECONDS.sleep(5);
        executorService.shutdownNow();
    }
}

class Sender implements Runnable {
    private Random random = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut() {
        return out;
    }

    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'Z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println(e + " sender writer Exception");
        } catch (InterruptedException e) {
            System.out.println(e + " sender interruption Exception");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader reader;

    public Receiver(Sender sender) throws IOException {
        //pipedRead的建立必须在构造器中与一个PipedWriter相关联
        reader = new PipedReader(sender.getOut());
    }

    public void run() {
        try {
            while (true) {
                //如果没有更多数据，管道将自动阻塞
                System.out.println("read : " + (char) reader.read());
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read Exception");
        }
    }
}

