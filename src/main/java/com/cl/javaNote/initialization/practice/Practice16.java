package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 创建一个String对象数据，并未每一个元素都赋值一个String
 * 用for循环打印该数组
 */
public class Practice16 {
    public static void main(String[] args) {
        String[] strings = {
                new String("1"),
                new String("4"),
                new String("3"),
                new String("2")
        };
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
        }
    }

}
