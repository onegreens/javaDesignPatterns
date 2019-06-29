package com.cl.leetcode;

public class PrintUtil {
    public static void print(int[] nums) {
        System.out.print("[");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.print("]");

    }
}
