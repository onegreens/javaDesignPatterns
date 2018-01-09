package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 通过创建对象赋值给引用数组
 * 修改Practice17
 */
public class Practice18 {
    public Practice18(String msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) {
        Practice18[] p = new Practice18[8];
        p[0] = new Practice18("test");
        p[01] = new Practice18("test1");
        p[02] = new Practice18("test2");
        p[03] = new Practice18("test3");
        p[04] = new Practice18("test4");
    }
}
