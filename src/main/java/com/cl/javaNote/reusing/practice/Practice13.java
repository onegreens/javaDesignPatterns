package com.cl.javaNote.reusing.practice;

/**
 * Created by cl on 2018/1/5.
 * 创建一个带有重载了三次的方法的类
 * 继承产生一个新类，并添加该方法的新的重载定义
 * 展示着四个方法在导出类中都是可以使用的
 */
public class Practice13 {
    public static void main(String[] args) {
        Reusing13Extends r = new Reusing13Extends();
        r.say();
        r.say(1);
        r.say(1d);
        r.say("");
    }
}

class Reusing13 {
    void say() {
        System.out.println("no agr");
    }

    void say(int i) {
        System.out.println("int agr");
    }

    void say(String i) {
        System.out.println("String agr");
    }
}

class Reusing13Extends extends Reusing13 {
    void say(double i) {
        System.out.println("double agr");
    }
}
