package com.cl.interview.FileOperation.arithmetic;

/**
 * Created by cl on 2018/1/15.
 * 一个整数，大于0，不用循环和本地变量，按照n，2n，4n，8n的顺序递增，当值大于5000时，把值按照指定顺序输出来。
 */
public class Test1 {
    void method(int num){
        if (num<5000){
            num *=2;
            System.out.println(num);
            method(num);
        }
    }

    public static void main(String[] args) {
        new Test1().method(1);
    }
}
