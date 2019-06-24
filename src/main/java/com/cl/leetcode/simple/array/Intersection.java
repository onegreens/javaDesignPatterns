package com.cl.leetcode.simple;

import static com.cl.javaNote.util.Print.print;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        print(intersection(nums1, nums2));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] nums = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            int numi = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (numi == nums2[j]) {
                    boolean add = true;
                    for (int k = 0; k < index; k++) {
                        if (numi == nums[k]) {
                            add = false;
                        }
                    }
                    if (add) {
                        nums[index] = numi;
                        index++;
                    }
                    break;
                }
            }
        }
        int[] result = new int[index];
        for (int i = 0; i < index; i++) {
            result[i] = nums[i];
        }
        return result;

    }
}
