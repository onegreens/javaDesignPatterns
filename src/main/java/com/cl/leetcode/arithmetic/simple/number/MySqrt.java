package com.cl.leetcode.arithmetic.simple;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(0));
        System.out.println(mySqrt(1));
        System.out.println(mySqrt(2));
        System.out.println(mySqrt(4));
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147483646));
        System.out.println(mySqrt(28));
        System.out.println(mySqrt(Integer.MAX_VALUE - 1));
    }

    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int base = 2;
        int num = 1;
        int max = 0;
        int min = 0;
        while (num <=x) {
            int multi = num * num;
            if (multi == x) {
                return num;
            } else if (multi < 1 || multi > x) {
                max = num;
                num = (num - min) / 2 + min;
            } else if (multi < x) {
                min = num;
                num *= base;
                if (max != 0 && num > max) {
                    num = (max - min) / 2 + min;
                }
            }
            if (max == min || max - min == 1) {
                return min;
            }
        }
        return num;
    }
}
