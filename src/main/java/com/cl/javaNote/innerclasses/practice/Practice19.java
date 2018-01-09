package com.cl.javaNote.innerclasses.practice;


/**
 * Created by cl on 2018/1/5.
 * 创建一个包含了嵌套类的类
 * 该嵌套类又包含有嵌套类
 * 查看编译器生成的。class文件的 名称
 */
public class Practice19 {
    static class Nest {
        static class InnerNest {
            public InnerNest() {
                System.out.println("InnerNest");
            }
        }

        static InnerNest getInner() {
            return new InnerNest();
        }
    }

    static Nest getNest() {
        return new Nest();
    }

    public static void main(String[] args) {
        Nest.getInner();
    }

}
