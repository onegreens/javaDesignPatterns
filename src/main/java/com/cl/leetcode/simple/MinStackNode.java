package com.cl.leetcode.simple;

import com.cl.leetcode.ListNode;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MinStackNode {
    public static void main(String[] args) {
        MinStackNode minStack = new MinStackNode();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
    ListNode cur = new ListNode(0);
    int index = -1;

    public MinStackNode() {

    }

    public void push(int x) {
        ListNode next = new ListNode(x);
        next.next = cur;
        cur = next;
        index++;

    }

    public void pop() {
        cur = cur.next;
        index--;
    }

    public int top() {
        return cur.val;
    }

    public int getMin() {
        if (index == -1)
            return 0;
        ListNode temp = cur;
        int min = temp.val;
        int num = index;
        while (num > -1) {
            num--;
            if (min > temp.val) {
                min = temp.val;
            }
            temp = temp.next;
        }
        return min;

    }
}
