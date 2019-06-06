package com.cl.test;

import java.util.HashMap;

/**
 * Created by cl on 2017/11/29.
 */
public class Test3 {
    static void change1(HashMap num) {
        num.put("num", 1);
    }

    static HashMap change2(HashMap num) {
        num.put("num", 2);
        return num;
    }

    public static void main(String[] args) {
        HashMap num = new HashMap();
        num.put("num", 0);
        System.out.println(num.get("num"));//0
        Test3.change1(num);
        System.out.println(num.get("num"));//1
        Test3.change2(num);
        System.out.println(num.get("num"));//2
    }
}
