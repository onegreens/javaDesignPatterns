package com.cl.leetcode.simple.array;

import java.util.Arrays;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class HeightChecker {
    public static void main(String[] args) {
        int[] nums = {1,1,4,2,1,3};
        System.out.println(heightChecker(nums));
    }
    public static int heightChecker(int[] heights) {
        int[] heights_ = heights.clone();
        Arrays.sort(heights);
        int num = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != heights_[i])
                num++;
        }
        return num;
    }
}
