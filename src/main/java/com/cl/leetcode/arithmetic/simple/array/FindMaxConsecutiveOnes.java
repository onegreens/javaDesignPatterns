package com.cl.leetcode.arithmetic.simple.array;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * <p>
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index == 0) {
                max = max > sum ? max : sum;
                sum = 0;
            } else {
                sum++;
            }
        }
        max = max > sum ? max : sum;
        return max;

    }
}
