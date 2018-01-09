package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 编写一个类 拥有两个静态字符串域
 * 其中一个在定义处初始化，另一个在静态块中初始化。
 * 在静态方法中打印两个字符串
 * 证明在使用前就已经初始化好了
 *
 */
public class Practice14 {
    static String string1 = new String("string1");
    static String string2;
    static {
        string2 = new String("string2");
    }
    static void say(){
        System.out.println(string1);
        System.out.println(string2);
    }

    public static void main(String[] args) {
        Practice14.say();
    }
}
