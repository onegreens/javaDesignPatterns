package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 创建一个名为Dog的类，它具有重载的bark()方法
 * 此方法应根据不同的基本数据类型进行重载，并根据被调用的版本，打印出不同的信息
 * 编写main来调用所有不同版本的方法
 *
 */
public class Practice5 {
    public static void main(String[] args) {
        Dog dog =new Dog();
        dog.bark();
        dog.bark(1);
        dog.bark("barking");

    }
}
//    no bark
//just 1 bark
//        it is barking
class Dog{
    void bark(){
        System.out.println("no bark");
    }
    void bark(int i){
        System.out.println("just "+i+" bark");
    }
    void bark(String bark){
        System.out.println("it is "+bark);
    }
}
