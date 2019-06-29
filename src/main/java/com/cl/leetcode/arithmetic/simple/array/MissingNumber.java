package com.cl.leetcode.arithmetic.simple.array;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {
    public static void main(String[] args) {

        int[] nums2 = {9,6,4,2,3,5,7,8,1};
        System.out.println(missingNumber(nums2));
    }
     static int missingNumber(int[] nums) {
        int[] arrays = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            arrays[index] = index;
        }
        for (int i = 1; i < arrays.length; i++) {
            if (arrays[i] == 0)
                return i;
        }
        return 0;
    }
}
