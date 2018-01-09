package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 创建一个包含内部类的类，在另一个独立的类中，创建此内部类的实例
 */
public class Practice5 {
    class Inner5{
        public Inner5() {
            System.out.println("初始化成功");
        }
    }

    public static void main(String[] args) {
        new Outer5().getInner();
    }
}
class Outer5{
    Practice5.Inner5 getInner(){
        return new Practice5().new Inner5();
    }
}
