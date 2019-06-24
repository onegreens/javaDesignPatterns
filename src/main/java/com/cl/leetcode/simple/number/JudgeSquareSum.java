package com.cl.leetcode.simple.number;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * <p>
 * 示例1:
 * <p>
 * 输入: 5
 * 输出: True
 * 解释: 1 * 1 + 2 * 2 = 5
 *  
 * <p>
 * 示例2:
 * <p>
 * 输入: 3
 * 输出: False
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        System.out.println(judgeSquareSum(12*12+88*88));
    }

    public static boolean judgeSquareSum(int c) {
        if (c == 0)
            return true;
        int s = (int) Math.sqrt(c);
        if (s * s == c)
            return true;
        for (int i = 1; i < s + 1; i++) {
            for (int j = s; j > 0; j--) {
                if (i > j)
                    break;
                int val = i * i + j * j;
                if (val == c)
                    return true;
                if (val < c) {
                    break;
                }
            }
        }
        return false;
    }
}
