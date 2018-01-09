package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 创建一个带默构造器（即无参构造器）的类，在构造器中打印一条消息
 * 为这个类创建一个对象
 */
public class Practice3 {
    public Practice3() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        new Practice3();
    }
}
//hello world
