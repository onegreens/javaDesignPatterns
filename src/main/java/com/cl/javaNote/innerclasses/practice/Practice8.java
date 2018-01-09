package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 确定外部类是否可以访问其内部类的private元素
 * 不可以  需要通过初始化
 */
public class Practice8 {
    class Inner8 {
        public Inner8(String name) {
            this.name = name;
        }

        private String name;
    }

    public void say() {
//        System.out.println(this.name);
//        System.out.println(Inner8.name);
        System.out.println(new Inner8("张三").name);
    }
}
