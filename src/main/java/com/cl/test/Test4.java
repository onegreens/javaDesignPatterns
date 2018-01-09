package com.cl.test;

import com.cl.javaNote.classInfo.ClassUtils;

/**
 * Created by cl on 2017/12/18.
 */
public class Test4 {
    static int t = 2;

    static {
        int test = 1;
        int r = t - test;
    }


    public static void main(String[] args) {
        Test2 newT = new Test2();
        newT.setName("张三");
        Test2 oldT = new Test2();
        oldT.setAge("18");
        oldT.setName("李四");

        ClassUtils.inheritValue(oldT, newT);
        System.out.println(oldT);
        System.out.println(Test4.class);
//        Test5 test5 = new Test6();
//        System.out.println();

    }
}
