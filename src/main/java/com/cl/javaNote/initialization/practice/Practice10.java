package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 先写具有finalize()方法的类，并在方法中打印消息。
 */
public class Practice10 {
    @Override
    protected void finalize(){
//        super.finalize();
        System.out.println("example is over");
    }

    public static void main(String[] args) {
        new Practice10();
        System.out.println("do gc");
        System.gc();//在执行gc时，会调用finalize()方法
    }
}
