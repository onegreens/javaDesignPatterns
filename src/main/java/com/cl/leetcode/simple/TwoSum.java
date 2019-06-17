package com.cl.leetcode.simple;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSum {
    public static void main(String[] args) {

        int[] nums =
                {-1, -2};
        System.out.println(twoSum(nums, -3));

    }

    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[0];
        }
        int[] result = new int[2];
        int len = numbers.length;
        int index = len - 1;
        while (index > 0) {
            int max = numbers[index];
            if (numbers[0] > 0 && max > target) {
                index--;
                continue;
            }
            for (int i = 0; i < index; i++) {
                if (max + numbers[i] == target) {
                    result[1] = index + 1;
                    result[0] = i + 1;
                    return result;
                }
                if (max + numbers[i] > target) {
                    break;
                }
            }
            index--;
        }
        return result;
    }
}
