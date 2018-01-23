package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2018/1/5.
 * 创建一个包含嵌套类的类
 * 在main中创建其内部类的实例
 */
public class Practice18 {
    static class Nest{
        class Inner{
            void say(){
                System.out.println("this:nest.inner.say ");
            }
        }
        void say(){
            getInner().say();
        }
        Inner getInner(){
            return new Inner();
        }
    }
    static Nest getNest(){
        return  new Nest();
    }

    public static void main(String[] args) {
        Nest nest = getNest();
        Nest.Inner inner = nest.getInner();
        inner.say();
    }
}
