package com.cl.pattern.singleton;

/**
 * Created by cl on 2017/6/30.
 * 双重检测
 */
public class DCSingleton {

    //利用一个静态变量来记录Singleton类的唯一实例
    //volatile关键字确保，当singleton变量被初始化时，多个线程能正确的处理singleton（不适用java1.4以前的版本）
    private volatile static DCSingleton singleton;

    //把构造器声明为私有的，只有Singleton类内才可以调用构造器
    private DCSingleton() {

    }

    //用getInstance方法实例化对象，并返回这个实例
    public static DCSingleton getInstance() {
        //检查变量，如果不存在就进入同步区块
        if (singleton == null) {
            //只有第一次才执行
            synchronized (DCSingleton.class) {
                //检查是否存在实例
                if (singleton == null) {
                    singleton = new DCSingleton();
                }
            }
        }
        return singleton;
    }

}
