package com.cl.pattern.singleton;

/**
 * Created by cl on 2017/6/30.
 * 多线程
 */
public class SynSingleton {

    //利用一个静态变量来记录Singleton类的唯一实例
    private static SynSingleton synSingleton;

    //把构造器声明为私有的，只有Singleton类内才可以调用构造器
    private SynSingleton(){

    }

    //用getInstance方法实例化对象，并返回这个实例
    //增加synchronized关键字 确保每次只有一个线程在调用
    public static synchronized SynSingleton getInstance(){
        //不存在就创建 存在就不创建
        if (synSingleton == null ){
            synSingleton = new SynSingleton();
        }
        return synSingleton;
    }
}
