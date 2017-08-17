package com.cl.javaNote.threadNote.blocked;

/**
 * Created by cl on 2017/8/10.
 * 说明一个互斥可以如何被同一个任务多次获取
 */
public class MultiLock {
    private int id;

    public MultiLock(int id) {
        this.id = id;
    }

    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1 - f2 :count - " + count+" id="+id);
            f2(count);
        }
    }

    public synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2 - f1 :count - " + count+" id="+id);
            f1(count);
        }
    }

    public static void main(String[] args) {
        final MultiLock m = new MultiLock(10);
        final MultiLock f = new MultiLock(2);
        new Thread(){
            public void run(){
                f.f1(10);
                m.f1(10);

            }
        }.start();
    }

}

