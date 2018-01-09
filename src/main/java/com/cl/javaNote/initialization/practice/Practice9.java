package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 编写具有两个（重载）构造器的类，并在第一个构造器中通过this调用第二个构造器
 */
public class Practice9 {
    public Practice9(String msg) {
        System.out.println(msg);
    }

    public Practice9(int i,String msg) {
        this(msg);
        System.out.println(i);
    }

    public static void main(String[] args) {
        new Practice9(1,"sang");
    }
}
