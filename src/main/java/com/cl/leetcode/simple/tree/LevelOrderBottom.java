package com.cl.leetcode.simple.tree;

import com.cl.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root != null) {
            List<List<Integer>> left = levelOrderBottom(root.left);
            List<List<Integer>> right = levelOrderBottom(root.right);
            int leftLen = left.size();
            int rightLen = right.size();
            int index = 0;
            int max = Math.max(leftLen, rightLen);
            while (index < max) {
                List<Integer> list = new ArrayList<>();
                if (index + leftLen >= max) {
                    list.addAll(left.get(index - (max - leftLen)));
                }
                if (index + rightLen >= max) {
                    list.addAll(right.get(index - (max - rightLen)));
                }
                result.add(list);
                index++;
            }
            List<Integer> rootList = new ArrayList<>();
            rootList.add(root.val);
            result.add(rootList);
        }
        return result;
    }
}
