package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 修改练习1，使得Outer类包含一个private String域（由构造器初始化）
 * 而Inner包含一个显示这个域的toString()方法，创建一个Inner类型的对象并显示它
 */
public class Practice3 {
    String name;

    public Practice3(String name) {
        this.name = name;
    }

    class Inner {
        public Inner() {
            System.out.println("初始化成功:"+Practice3.this.name);
        }
    }

    public Inner getInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        new Practice3("张三").getInner();
    }
}
