package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 编写一个含有字符串域的类，并采用实例初始化方法进行初始化
 */
public class Practice15 {
    String string;

    public Practice15() {
        string = new String("string");
    }

    public static void main(String[] args) {
        System.out.println(new Practice15().string);
    }
}
