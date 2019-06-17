package com.cl.leetcode.simple;

import com.cl.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 */
public class AverageOfLevels {
    public static void main(String[] args) {

    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if (root != null) {
            LinkedList<TreeNode> roots = new LinkedList<>();
            roots.add(root);
            while (!roots.isEmpty()) {
                int size = roots.size();
                double sum = 0;
                for(int i=0;i<size;i++) {
                    TreeNode node = roots.poll();
                    sum += node.val;
                    if (node.left != null)
                        roots.add(node.left);
                    if (node.right != null)
                        roots.add(node.right);
                }
                list.add(sum / size);
            }
        }
        return list;
    }

}
