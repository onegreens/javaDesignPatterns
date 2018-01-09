package com.cl.javaNote.threadNote.base;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by cl on 2017/8/7.
 * 从任务中产生返回值，通过实现Callable接口，实现其call()方法，
 *
 * 通过submit方法启动,方法会参数Future对象，可通过isDone()方法来查询future是否完成，任务完成后可通过get()方法获取future对象的值
 */
public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            futures.add(service.submit(new TaskWithResult(i)));//
        }
        for (Future<String> future :futures){
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                service.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    public String call() throws Exception {
        return "result of taskWithResult " + id;
    }
}