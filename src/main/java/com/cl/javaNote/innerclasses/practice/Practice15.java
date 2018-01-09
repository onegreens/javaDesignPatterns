package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 创建一个类，他有非默认的构造器（即需要参数的构造器）
 * 并且没有默认构造器（没有无参数的构造器）
 * 创建第二个类，它包含一个方法，能够返回第一个类的对象的引用
 * 通过写一个继承自第一个类的匿名内部类，来创建一个返回对象
 */
public class Practice15 {
    Entity15 get(String name) {
        return new EntityExtends15(name);
    }
}

class Entity15 {
    public Entity15(String name) {
        System.out.println("初始化Entity15：" + name);
    }

}

class EntityExtends15 extends Entity15{

    public EntityExtends15(String name) {
        super(name);
    }
}
