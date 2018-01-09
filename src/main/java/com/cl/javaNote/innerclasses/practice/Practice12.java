package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * <p>
 * 重复Practice7 这次使用匿名内部类
 */
public class Practice12 {
    public Practice12(String name) {
        this.name = name;
    }

    private String name;

    private void say() {
        System.out.println("Practice7:just say " + name);
    }

    void sayName(String name) {
        getInner12().change(name);
    }

    Inner12 getInner12() {
        return new Inner12() {
            public void change(String name) {
                Practice12.this.name = name;
                Practice12.this.say();
            }
        };
    }

    public static void main(String[] args) {
        new Practice12("张桑").sayName("李四");
    }

}

abstract class Inner12 {//需要先定义一个接口或者抽象类
    void change(String name){

    }
}
