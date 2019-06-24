package com.cl.leetcode.simple.defineClass;

import java.util.ArrayList;
import java.util.List;

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
public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    int index = -1;
    List<Integer> list = new ArrayList();

    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        index++;

    }

    public void pop() {
        list.remove(index);
        index--;
    }

    public int top() {
        return list.get(index);
    }

    public int getMin() {
        if (index == -1)
            return 0;
        int min = list.get(index);
        if (index == 0)
            return min;
        for (int i = 0; i < list.size() - 1; i++) {
            int num = list.get(i);
            if (min > num)
                min = num;
        }
        return min;
    }
}
