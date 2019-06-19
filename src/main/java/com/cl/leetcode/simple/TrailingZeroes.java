package com.cl.leetcode.simple;

/**
 * 给定一个整数 n，返回 n! 结果尾数中零的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(625));
    }

    public static int trailingZeroes(int n) {
        int num = 0;
        if (n >= 5) {
            return n / 5 + trailingZeroes(n / 5);
        }
        return num;
    }

}
