package com.cl.pattern.singleton;

/**
 * Created by cl on 2017/6/30.
 * 预先实例化
 */
public class NewSingleton {

    //利用一个静态变量来记录NewSingleton类的唯一实例,预先实例化
    private static NewSingleton singleton =  new NewSingleton();

    //把构造器声明为私有的，只有NewSingleton类内才可以调用构造器
    private NewSingleton(){

    }

    //用getInstance方法实例化对象，并返回这个实例
    public static NewSingleton getInstance(){
        return singleton;
    }
}
