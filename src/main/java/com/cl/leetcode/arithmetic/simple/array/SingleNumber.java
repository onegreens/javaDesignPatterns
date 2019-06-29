package com.cl.leetcode.arithmetic.simple;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        for (int i = 0; i < nums.length; i++) {
            int numi = nums[i];
            boolean isSingle = true;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (numi == nums[j]) {
                        isSingle = false;
                        break;
                    }
                }

            }
            if (isSingle)
                return numi;
        }
        return 0;
    }
}
