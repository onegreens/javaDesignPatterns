package com.cl.javaNote.threadNote.blocked;

import com.cl.javaNote.threadNote.blocked.IOBlocked;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by cl on 2017/8/9.
 * 关闭任务在其上发生阻塞的底层资源
 */
public class CloseResource {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(8080);
        InputStream inputStream = new Socket("localhost",8080).getInputStream();
        executorService.execute(new IOBlocked(inputStream));
        executorService.execute(new IOBlocked(System.in));
        TimeUnit.MILLISECONDS.sleep(108);
        System.out.println("关闭所有线程");
        executorService.shutdownNow();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing "+inputStream.getClass().getName());
        inputStream.close();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("closing "+System.in.getClass().getName());
        System.in.close();
    }
}
