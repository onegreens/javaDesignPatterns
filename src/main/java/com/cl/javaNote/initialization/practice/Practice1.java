package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 创建一个类，它包含一个为初始化的String引用
 * 验证该引用被Java初始化为null
 */
public class Practice1 {
    String name;

    public static void main(String[] args) {
        System.out.println("name:"+new Practice1().name);
    }
}
//name:null