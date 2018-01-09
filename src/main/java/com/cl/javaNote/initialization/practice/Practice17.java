package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 创建一个类，它有一个接受String参数的构造器
 * 在构造器阶段 打印该参数
 * 创建一个该类的对象引用数组，但是不实际的去创建对象赋值给该数组。
 * 当运行程序时，查看是否有打印信息
 */
public class Practice17 {
    public Practice17(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
       Practice17[] practice17s = {
               new Practice17("test4"),
               new Practice17("test3"),
               new Practice17("test2"),
               new Practice17("test1")
       };
    }

}

