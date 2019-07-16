package com.cl.leetcode.arithmetic.simple.tree;

import com.cl.leetcode.arithmetic.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其层序遍历:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Node> list = new ArrayList();
        list.add(root);
        while (list.size() > 0) {
            List<Node> next = new ArrayList();
            List<Integer> item = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                Node cur = list.get(i);
                if(cur == null)continue;
                item.add(cur.val);
                if (cur.children != null && cur.children.size() > 0)
                    next.addAll(cur.children);
            }
            if(item.size()>0){
                result.add(item);
                list = next;
            }

        }
        return result;
    }
}


