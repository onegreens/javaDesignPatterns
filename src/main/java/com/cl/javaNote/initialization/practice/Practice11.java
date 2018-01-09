package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 修改Practice10
 * 让你的finalize()总会被调用
 */
public class Practice11 {
    public void gc(){
        System.gc();
    }
    public void say(){
        System.out.println("test");
    }
    @Override
    protected void finalize() throws Throwable {
//        super.finalize();
        System.out.println("example is over");
    }

    public static void main(String[] args) throws Throwable {
        Practice11 practice11 = new Practice11();//在这种情况下 并不会调用finalize 可能是因为对象还存在
        System.out.println("do gc");
        System.gc();

        //在执行gc时，会调用finalize()方法
    }
}
