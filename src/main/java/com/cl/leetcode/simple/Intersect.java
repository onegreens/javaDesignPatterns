package com.cl.leetcode.simple;

import static com.cl.javaNote.util.Print.print;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class Intersect {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        print(intersect(nums1, nums2));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums = new int[Math.max(len1, len2)];
        int index = 0;
        for (int i = 0; i < len1; i++) {
            int numi = nums1[i];
            int eq = 0;
            for (int j = 0; j < len2; j++) {
                if (numi == nums2[j]) {
                    eq++;
                    int same = 0;
                    for (int k = 0; k < index; k++) {
                        if (numi == nums[k]) {
                            same++;
                        }
                    }
                    if (eq > same) {
                        nums[index] = numi;
                        index++;
                        break;
                    }
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
