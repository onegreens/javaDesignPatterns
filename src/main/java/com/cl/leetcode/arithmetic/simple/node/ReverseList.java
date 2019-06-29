package com.cl.leetcode.arithmetic.simple;

import com.cl.leetcode.arithmetic.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode pre = head;
        while (pre != null) {
            ListNode index = new ListNode(0);
            result.val = pre.val;
            index.next = result;
            result = index;
            pre = pre.next;
        }
        return result.next;
    }

}
