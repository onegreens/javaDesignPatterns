package com.cl.leetcode.arithmetic.simple.array;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class ThirdMax {
    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(thirdMax(nums));

    }


    public static int thirdMax(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int one = nums[0];
        Integer two = null;
        Integer three = null;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num == one)
                continue;
            if (num > one) {
                three = two;
                two = one;
                one = num;
            } else {

                if (two == null) {
                    two = num;
                    continue;
                }
                if (num == two)
                    continue;
                if (num > two) {
                    three = two;
                    two = num;
                } else {
                    if (three == null) {
                        three = num;
                        continue;
                    }
                    if (num == three)
                        continue;
                    if (num > three) {
                        three = num;
                    }
                }
            }
        }

        if (three == null || two == three)
            return one;
        return three;

    }

}
