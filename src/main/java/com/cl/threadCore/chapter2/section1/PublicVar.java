package com.cl.threadCore.chapter2.section1;

/**
 * 线程A占有对象的锁方法时,其他线程可以执行该对象的非锁方法
 *
 * 线程A占有对象的锁方法时,其他线程要执行该对象的锁方法必须等线程A执行完
 */
public class PublicVar {
    private String username = "asd";
    private String password = "123";

    public synchronized void setValue(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(3000);
            this.password = password;
            System.out.println("set value " + toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void getValue() {
//    public void getValue() {
        System.out.println("getValue value " + toString());
    }

    @Override
    public String toString() {
        return "PublicVar{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        PVThread pvThread = new PVThread(publicVar);
        pvThread.start();
        Thread.sleep(1000);//输出结果受时间影响
        publicVar.getValue();
        /**
         未同步getValue
         getValue value PublicVar{username='qwe', password='123'}
         set value PublicVar{username='qwe', password='456'}

         同步getValue
         set value PublicVar{username='qwe', password='456'}
         getValue value PublicVar{username='qwe', password='456'}
         */
    }
}

class PVThread extends Thread {
    PublicVar publicVar;

    @Override
    public void run() {
        publicVar.setValue("qwe", "456");
    }

    public PVThread(PublicVar publicVar) {
        this.publicVar = publicVar;
    }
}
