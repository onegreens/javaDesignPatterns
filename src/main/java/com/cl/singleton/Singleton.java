package com.cl.singleton;

/**
 * Created by cl on 2017/6/30.
 * 基本的单例模式
 */
public class Singleton {

    //利用一个静态变量来记录Singleton类的唯一实例
    private static Singleton singleton;

    //把构造器声明为私有的，只有Singleton类内才可以调用构造器
    private Singleton(){

    }

    //用getInstance方法实例化对象，并返回这个实例
    public static Singleton getInstance(){
        //不存在就创建 存在就不创建
        if (singleton == null ){
            singleton = new Singleton();
        }
        return singleton;
    }

}
