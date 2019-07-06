package com.cl.leetcode.simple.array;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 */
public class LargestPerimeter {
    public static void main(String[] args) {
//        int[] nums = {2, 1, 2};
//        int[] nums = {1,2,1};
//        int[] nums = {3,6,2,3};
        int[] nums = {3,2,3,4};
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int left, right;
        for (right = 1; right < A.length; right++) {
            int temp = A[right];
            left = right;
            while (left > 0 && A[left - 1] >= temp) {
                A[left] = A[left - 1];
                --left;
            }
            A[left] = temp;
        }
        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;

    }
}
