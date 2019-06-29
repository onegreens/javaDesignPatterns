package com.cl.leetcode.list.parctice;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 * <p>
 * 我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2:
 * <p>
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: -1
 * 解释:
 * 数组中不存在满足此条件的中心索引。
 * 说明:
 * <p>
 * nums 的长度范围为 [0, 10000]。
 * 任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class PivotIndex {
    public static void main(String[] args) {

//        int[] nums1 = {1, 7, 3, 6, 5, 6};
        int[] nums1 = {1};
        System.out.println(pivotIndex(nums1));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1)
            return 0;
        int sum = 0;
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            int index = sum + nums[right] - nums[left];
            if (index == 0) {
                if (right - left == 2) {
                    return left + 1;
                } else {
                    left++;
                    right--;
                }
            } else if (index > 0) {
                sum += -nums[left];
                left++;
            } else {
                sum += nums[right];
                right--;
            }
        }
        return -1;
    }
}
