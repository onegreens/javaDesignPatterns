package com.cl.leetcode.simple;

import com.cl.leetcode.ListNode;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        int min = head.val;
        ListNode pre = head;
        while (pre != null) {
            ListNode node = pre.next;
            if (node == null) break;
            if (node.val == min) {
                pre.next = node.next;
            } else {
                min = node.val;
                pre = pre.next;
            }
        }
        return head;
    }
}
