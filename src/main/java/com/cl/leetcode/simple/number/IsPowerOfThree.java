package com.cl.leetcode.simple.number;

/**
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 27
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: true
 * 示例 4:
 * <p>
 * 输入: 45
 * 输出: false
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        System.out.println(1162261467 / 177147);
    }

    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
