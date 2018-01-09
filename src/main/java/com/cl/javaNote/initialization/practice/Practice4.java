package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 在Practice3中添加一个重载构造器，令其接受一个字符创参数，
 * 并在构造器中把你自己的消息和接收的参数一起打印出来
 */
public class Practice4 {
    public Practice4(String msg) {
        System.out.println("hello world !"+msg);
    }

    public static void main(String[] args) {
        System.out.println(new Practice4("zhangsan"));
    }
}
//    hello world !zhangsan