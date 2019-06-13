package com.cl.leetcode.simple;

import com.cl.leetcode.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left == null && right == null)
            return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        TreeNode out = new TreeNode(0);
        out.left = left.left;
        out.right = right.right;

        TreeNode inner = new TreeNode(0);
        inner.left = left.right;
        inner.right = right.left;
        return isSymmetric(inner) && isSymmetric(out);
    }


}
