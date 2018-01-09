package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 重复Practice9，但将内部类定义在某个方法的一个作用域内
 */
public class Practice10 {
    public Method10 test(){
        return new Method10(){
            public void say() {
                System.out.println("just say");
            }
        };
    }
}
interface Method10{
    void say();
}
