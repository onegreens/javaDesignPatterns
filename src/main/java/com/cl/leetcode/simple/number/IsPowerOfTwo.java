package com.cl.leetcode.simple.number;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 * <p>
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 * <p>
 * 输入: 218
 * 输出: false
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(218));
    }

    public static boolean isPowerOfTwo(int n) {
        if ((n > 1 && n % 2 == 1) || n < 1) return false;
        while (n >= 1) {
            if (n % 2 == 1) return false;
            n /= 2;
        }
        return true;
    }

    public static boolean isPowerOfTwo1(int n) {
        int num = 1;
        while (num <= n) {
            if (num == n)
                return true;
            num *= 2;
        }
        return false;
    }
}
