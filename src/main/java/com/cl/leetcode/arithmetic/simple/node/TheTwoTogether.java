package com.cl.leetcode.arithmetic.simple;

import com.cl.leetcode.arithmetic.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class TheTwoTogether {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        if (l1 == null && l2 == null) {
            return result;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int together = l1.val + l2.val;
        boolean add = false;
        if (together > 9) {
            add = true;
            result = new ListNode(together - 10);
        } else {
            result = new ListNode(together);
        }
        ListNode next = null;
        if (l1.next == null && l1.next == null) {
        } else if (l1.next == null) {
            next = l2.next;
        } else if (l2.next == null) {
            next = l1.next;
        }
        if (next == null) {
            next = addTwoNumbers(l1.next, l2.next);
        }
        if (next != null) {
            ListNode target = next;
            while (add) {
                if (target != null) {
                    target.val = target.val + 1;
                    if (target.val > 9) {
                        target.val = target.val - 10;
                        if (target.next == null) {
                            target.next = new ListNode(1);
                            add = false;
                        } else {
                            target = target.next;
                            add = true;
                        }
                    } else {
                        add = false;
                    }
                }
            }
        } else {
            if (add) {
                next = new ListNode(1);
            }
        }
        result.next = next;

        return result;
    }
}

