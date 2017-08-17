package com.cl.javaNote.threadNote.blocked;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/10.
 * nio类提供的I/O中断。被阻塞的nio通道会自动地响应中断
 *
 *
 */
public class NIOInterruption {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InetSocketAddress isa = new InetSocketAddress("localhost",8080);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);
        Future f=executorService.submit(new NIOBlocked(sc1));
        executorService.execute(new NIOBlocked(sc2));
        executorService.shutdown();//使用execute来启动多个任务，并调用shutdownNow()将可以很容易终止所有事物
        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);//只中断当前线程，不影响其他线程
        TimeUnit.SECONDS.sleep(1);
        sc2.close();//可以关闭底层资源以释放锁，但是不是必须的
    }
}

class NIOBlocked implements Runnable {
    private final SocketChannel sc;

    public NIOBlocked(SocketChannel sc) {
        this.sc = sc;
    }

    public void run() {
        try {
            System.out.println("waiting for read in "+this);
            sc.read(ByteBuffer.allocate(1));
        } catch (IOException e) {
            System.out.println("中断。。。");
        }
        System.out.println("exiting nioblocked.run() "+this);
    }
}


