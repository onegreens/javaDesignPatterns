package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 创建至少有一个方法的接口，在某个方法内定义一个内部类以实现此接口
 * 这个方法返回此接口的引用
 */
public class Practice9 {
    public Method9 test(){
        class Method9Impl implements Method9{
            public void say() {
                System.out.println("just say");
            }
        }
        return new Method9Impl();
    }
}
interface Method9{
    void say();
}
