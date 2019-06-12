package com.cl.leetcode.simple;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveNodeElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (head != null) {
            if(head.val == val){
                head = head.next;
                continue;
            }

            cur.next = new ListNode(head.val);
            cur = cur.next;
            head = head.next;

        }
        return result.next;
    }
}
