package com.cl.leetcode.arithmetic.simple.tree;

import com.cl.dataStructures.array.Array;
import com.cl.leetcode.arithmetic.TreeNode;
import org.apache.poi.ss.formula.functions.T;

import java.util.*;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 */
public class SumRootToLeaf {
    public static void main(String[] args) {
        //TODO
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        System.out.println(sumRootToLeaf(root));
    }

    public static int sumRootToLeaf(TreeNode root) {
        List<String> strs = new ArrayList<>();
        List<List<TreeNode>> nodes = new ArrayList<>();
        strs.add("");
        List<TreeNode> def = new ArrayList<>();
        def.add(root);
        nodes.add(def);

        boolean run = true;
        while (run) {
            run = false;
            List<String> strs_ = new ArrayList<>();
            List<List<TreeNode>> nodes_ = new ArrayList<>();
            for (int i = 0; i < strs.size(); i++) {
                String str = strs.get(i);
                List<TreeNode> list = nodes.get(i);
                for (int j = 0; j < list.size(); j++) {
                    TreeNode node = list.get(j);
                    strs_.add(str+node.val);
                    List<TreeNode> values = new ArrayList<>();
                    if (node.right != null) {
                        values.add(node.right);
                        run = true;
                    }
                    if (node.left != null) {
                        values.add(node.left);
                        run = true;
                    }
                    nodes_.add(values);
                }
            }
            strs = strs_;
            nodes = nodes_;

        }
        int result = 0;
        for (String str : strs) {
            int len = str.length();
            int index = 0;
            int sum = 0;
            for (int i = len - 1; i > -1; i--) {
                sum += Integer.parseInt(String.valueOf(str.charAt(i))) * Math.pow(2, index);
                index++;
            }
            result += sum;
        }
        return result;
    }
}
