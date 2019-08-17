package com.cl.leetcode.arithmetic;

import java.util.ArrayList;
import java.util.List;

public class NodeUtils {

    public static TreeNode getTreeNode(String[] nums) {
        TreeNode def = new TreeNode(Integer.parseInt(nums[0]));
        List<TreeNode> deflist = new ArrayList<>();
        deflist.add(def);
        List<List<TreeNode>> nodeList = new ArrayList<>();
        nodeList.add(deflist);
        int index = 0;
        int layer = 0;
        List<TreeNode> list = new ArrayList<>();
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            TreeNode node = null;
            if (nums[i] != null) {
                node = new TreeNode(Integer.parseInt(nums[i]));
            }
            List<TreeNode> layerNode = nodeList.get(layer);
            TreeNode parent = layerNode.get(index);
            if (num == 0) {
                parent.left = node;
            }
            if (num == 1) {
                parent.right = node;
            }
            num++;
            if (num == 2) {
                index++;
                num = 0;
            }
            list.add(node);
            if (index == layerNode.size()) {
                layer++;
                index = 0;
                nodeList.add(list);
                list = new ArrayList<>();
            }
        }
        return def;
    }

    public static void main(String[] args) {
        String[] nums = {"0", "1", "0", "0", null, "0", "0", null, null, null, "1", null, null, null, "1"};
        System.out.println(getTreeNode(nums));
    }

    public static int getIndexNum(int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += Math.pow(2, i);
        }
        return sum;
    }
}
