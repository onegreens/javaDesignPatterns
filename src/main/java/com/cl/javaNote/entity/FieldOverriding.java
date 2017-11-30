package com.cl.javaNote.entity;

/**
 * Created by cl on 2017/11/30.
 * 在子类会覆盖父类的方法 不会覆盖父类的常量
 * 重写，指的是方法。 成员变量并不会被重写
 */
public class FieldOverriding {
    public static void main(String[] args) {
        Sub c1 = new Sub();
        System.out.println(" c1.s : " + c1.s);
        System.out.println(" c1.say : " + c1.say());

        Super c2 = new Sub();
        System.out.println(" c2.s : " + c2.s);
        System.out.println(" c2.say : " + c2.say());
    }
}

class Super {
    String s = "Super";

    String say(){
        return "hello Super";
    }
}

class Sub extends Super {
    String s = "Sub";

    String say(){
        return "hello Sub";
    }
}
