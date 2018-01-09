package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 重复练习9 这次使用匿名内部类
 */
public class Practice13 {
    public Method9 test() {
        return new Method9() {
            public void say() {
                System.out.println("just say");
            }
        };
    }
}
