package com.cl.leetcode.simple;

/**
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 * <p>
 * 说明：不要使用任何内置的库函数，如  sqrt。
 * <p>
 * 示例 1：
 * <p>
 * 输入：16
 * 输出：True
 * 示例 2：
 * <p>
 * 输入：14
 * 输出：False
 */
public class IsPerfectSquare {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        System.out.println(isPerfectSquare(46340*46340));
    }

    public static boolean isPerfectSquare(int num) {
        if (num < 1)
            return false;
        int base = 1;
        int min = 1;
        int max = 46340;
        while (base < max) {
            int bases = base * base;
            if (bases == num) {
                return true;
            } else if (bases < num) {
                int nexts = (base + 1) * (base + 1);
                if (nexts > num)
                    break;
                if (nexts == num)
                    return true;
                if(base + 1 == max)
                    return false;
                min = base;
                base = base * 2;
                if (base > max) {
                    base = (max - min) / 2 + min;
                }

            } else {
                max = base;
                base = (max - min) / 2 + min;
            }


        }
        return false;
    }
}
