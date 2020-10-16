package com.cl.leetcode.arithmetic.simple.array;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 */
public class SortedSquares {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            int index = A[i] * A[i];
            A[i] = index;
        }
        int in;
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            in = i;
            while (in > 0 && A[in - 1] >= temp) {
                A[in] = A[in - 1];
                --in;
            }
            A[in] = temp;

        }
        return A;
    }
}
