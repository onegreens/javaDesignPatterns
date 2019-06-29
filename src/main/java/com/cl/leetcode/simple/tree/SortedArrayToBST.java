package com.cl.leetcode.simple;

import com.cl.leetcode.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class SortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        System.out.println(sortedArrayToBST(nums));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return null;
        else if (len == 1)
            return new TreeNode(nums[0]);
        else {
            int half = len / 2;
            TreeNode result = new TreeNode(nums[half]);
            if (half > 0) {
                int[] left = new int[half];
                for (int i = 0; i < left.length; i++) {
                    left[i] = nums[i];
                }
                result.left = sortedArrayToBST(left);

            }
            if (len - half > 1) {
                int[] right = new int[len - half - 1];
                for (int i = 0; i < right.length; i++) {
                    right[i] = nums[half + 1 + i];
                }
                result.right = sortedArrayToBST(right);
            }
            return result;
        }
    }
}
