package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2018/1/5.
 * 创建一个包含嵌套类的接口
 * 实现此接口并创建嵌套类的实例
 */
public class Practice20 {
    public static void main(String[] args) {
        new Inter.InterP20().say();
    }
}
interface Inter{
    void say();
    class InterP20 implements Inter{

        public void say() {
            System.out.println("接口内的嵌套类");
        }
    }
}
