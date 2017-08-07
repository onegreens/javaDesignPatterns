package com.work.util;

import java.util.Arrays;

/**
 * Created by cl on 2017/8/4.
 */
public class SpringTest {

    public static void main(String[] args) {
        SpringTest.test2();
    }

    static void test1() {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("-1234".matches("-\\d+"));
        System.out.println("-a1234".matches("-\\d+"));
        System.out.println("a1234".matches("-?\\d+"));
        System.out.println("1234".matches("-?\\d+"));
        System.out.println("+1234".matches("(-|\\+)?\\d+"));
    }

    static void test2() {
        System.out.println(Arrays.toString("123123123".split("2")));
        System.out.println(Arrays.toString("1card , 1then".split("d|t")));//一个单词
        System.out.println(Arrays.toString("card,then".split("\\W+")));//非单词字符
    }
}
