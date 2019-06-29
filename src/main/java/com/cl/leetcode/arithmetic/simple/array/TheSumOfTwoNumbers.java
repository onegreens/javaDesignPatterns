package com.cl.leetcode.arithmetic.simple;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 */
public class TheSumOfTwoNumbers {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int index = nums[i];
            for (int j = i + 1; j < nums.length ; j++) {
                int other = nums[j];
                if (index + other == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums =  {2, 7, 11, 15};
        int target = 26;
        int[] result = new TheSumOfTwoNumbers().twoSum(nums,target);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }
}
