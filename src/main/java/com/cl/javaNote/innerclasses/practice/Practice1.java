package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 编写一个名为outer的类，它包含一个名为inner的类。在Outer中添加一个方法，它返回一个Inner类型的对象
 * 在mian中，创建并初始化一个指向某个Inner对象的引用
 */
public class Practice1 {
    class Inner{
        public Inner(){
            System.out.println("初始化成功");
        }
    }

    public Inner getInner(){
        return new Inner();
    }

    public static void main(String[] args) {
        Inner i = new Practice1().getInner();
    }
}
