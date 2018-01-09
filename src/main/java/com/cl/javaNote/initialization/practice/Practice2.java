package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 创建一个类，它包含一个在定义时就被初始化了的String域，以及另一个通过构造器初始化的String域，
 * 这两个方法有什么区别
 *
 * 区别：
 * 构造器初始化的值会覆盖定义时的值
 * 先定义 后构造器初始化
 */
public class Practice2 {
    String str = new String("abc");

    public Practice2(int str) {
        this.str = new String("def");
    }

    public Practice2() {
    }

    public static void main(String[] args) {
        System.out.println(new Practice2().str);
        System.out.println(new Practice2(1).str);
    }
}
