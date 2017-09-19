package com.cl.dataStructures.recursion;

/**
 * Created by cl on 2017/9/14.
 * 递归的简单用法
 */
public class Triangle {
    static int number;

    static int triangle(int n) {
        if (n == 1)
            return 1;
        else
            return n + triangle(n - 1);
    }

    /**
     * 加法实现乘法
     * @param x
     * @param y
     * @return
     */
    static int add(int x, int y) {
        if (y-- > 0) {
            return x + add(x, y);
        }
        return 0;
    }

    /**
     * 乘法实现乘方
     * @param x
     * @param y
     * @return
     */
    static int c(int x, int y) {
        if (y-- > 0) {
            return x * c(x, y);
        }
        return 1;
    }

    public static void main(String[] args) {
//        System.out.println(triangle(20));
//        System.out.println(add(5, 4));
        System.out.println(c(5, 2));
    }
}
