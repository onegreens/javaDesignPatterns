package com.cl.leetcode.simple;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        while (p != null || q != null) {
            if (p == null) {
                curr.next = q;
                break;
            }
            if (q == null) {
                curr.next = p;
                break;
            }
            if (p.val == q.val) {
                curr.next = new ListNode(q.val);
                curr = curr.next;
                curr.next = new ListNode(p.val);
                q = q.next;
                p = p.next;
            } else if (p.val > q.val) {
                curr.next = new ListNode(q.val);
                q = q.next;
            } else {
                curr.next = new ListNode(p.val);
                p = p.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
