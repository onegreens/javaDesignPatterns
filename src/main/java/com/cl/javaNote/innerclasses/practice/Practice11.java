package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 创建一个private内部类，让他实现一个public接口，
 * 写一个方法，它返回一个指向此private内部类的实例的引用，并将此引用向上转型为该接口类型
 */
public class Practice11 {
    private class Inner11 implements Method11 {
        public void say() {
            System.out.println("just say");
        }
    }

    Method11 getMethod11() {
        return new Inner11();
    }

    void doSay() {
        Inner11 inner11 = (Inner11) getMethod11();
        inner11.say();
    }

    public static void main(String[] args) {
        new Practice11().doSay();
    }
}
