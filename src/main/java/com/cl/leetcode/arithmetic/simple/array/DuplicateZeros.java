package com.cl.leetcode.arithmetic.simple.array;

import static com.cl.leetcode.arithmetic.PrintUtil.print;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        print(arr);

    }

    public static void duplicateZeros1(int[] arr) {
        int len = arr.length;
        int zero = 0;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                zero++;
                len--;
            }
        }
        for (int i = arr.length - 1; i > 0; i--) {

            if (arr[i - zero] == 0) {
                arr[i] = 0;
                arr[i - 1] = 0;
                i--;
                zero--;
            } else {
                arr[i] = arr[i - zero];
            }
        }

    }

    public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                for (int j = len-1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }

    }
}
