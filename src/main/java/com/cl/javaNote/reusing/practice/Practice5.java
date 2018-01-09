package com.cl.javaNote.reusing.practice;

/**
 * Created by cl on 2018/1/4.
 * 创建两个带有默认构造器（空参数列表）的类A和类B
 * 从A类中继承产生C类
 * 并在C中创建一个B类的成员
 * 不要给C创建构造器
 * 创建一个C类的对象，观察其行为
 */
public class Practice5 {
    public static void main(String[] args) {
        new C5();
    }
}

class A5 {
    public A5() {
        System.out.println("A");
    }
}

class B5{
    public B5() {
        System.out.println("B");
    }
}
class C5 extends A5{
    B5 b = new B5();
}
