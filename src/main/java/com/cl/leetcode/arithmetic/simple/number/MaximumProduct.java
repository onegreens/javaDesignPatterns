package com.cl.leetcode.arithmetic.simple.number;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: 24
 * 注意:
 * <p>
 * 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int result1 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        int result2 = nums[0] * nums[1] * nums[len - 1];
        return result1 > result2 ? result1 : result2;
    }

    public int maximumProduct1(int[] nums) {
        int[] maxs = {nums[0], nums[1], nums[2]};
        int[] mins = {nums[0], nums[1], nums[2]};
        Arrays.sort(maxs);
        Arrays.sort(mins);
        for (int i = 3; i < nums.length; i++) {
            int num = nums[i];
            if (num >= maxs[2]) {
                maxs[0] = maxs[1];
                maxs[1] = maxs[2];
                maxs[2] = num;
            } else if (num >= maxs[1]) {
                maxs[0] = maxs[1];
                maxs[1] = num;
            } else if (num >= maxs[0]) {
                maxs[0] = num;
            }

            if (num <= mins[0]) {
                mins[2] = mins[1];
                mins[1] = mins[0];
                mins[0] = num;
            } else if (num <= mins[1]) {
                mins[2] = mins[1];
                mins[1] = num;
            } else if (num <= mins[2]) {
                mins[2] = num;
            }
        }
        int result1 = maxs[2] * maxs[1] * maxs[0];
        int result2 = mins[2] * mins[1] * mins[0];
        return result1 > result2 ? result1 : result2;
    }
}
