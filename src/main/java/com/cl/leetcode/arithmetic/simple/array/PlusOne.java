package com.cl.leetcode.arithmetic.simple;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[len + 1];
        int index = 0;
        boolean add = true;
        while (index < len) {
            if (add) {
                digits[len - 1 - index] = digits[len - 1 - index] + 1;
                if (digits[len - 1 - index] > 9) {
                    digits[len - 1 - index] = 0;
                    add = true;
                } else {
                    if (index <= len - 1) {
                        return digits;
                    }
                    add = false;
                }
            }
            result[len - index] = digits[len - 1 - index];
            index++;
        }
        result[0] = 1;
        return result;

    }
}
