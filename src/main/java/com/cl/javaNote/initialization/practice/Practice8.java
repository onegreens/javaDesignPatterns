package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 编写具有两个方法的类
 * 在第一个方法内调用第二个方法两次：第一次不用this，第二次用this
 * 这种方法并不提倡
 */
public class Practice8 {
    public void method1(){
        System.out.println("hello world");
    }
    public void method2(){
        method1();
        this.method1();
    }

    public static void main(String[] args) {
        new Practice8().method2();
    }
}
//    hello world
//    hello world
