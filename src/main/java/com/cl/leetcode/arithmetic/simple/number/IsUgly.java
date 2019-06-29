package com.cl.leetcode.arithmetic.simple.number;

/**
 * 编写一个程序判断给定的数是否为丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 * <p>
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 * 说明：
 * <p>
 * 1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 */
public class IsUgly {
    public static void main(String[] args) {
        System.out.println(isUgly(Integer.MAX_VALUE));
    }

    public static boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        int[] nums = {2, 3, 5};
        for (int i = 0; i < 3; i++) {
            int index = nums[i];
            while (num > 1)
                if (num % index == 0) {
                    num /= index;
                } else {
                    break;
                }
        }
        return num == 1;
    }
}
