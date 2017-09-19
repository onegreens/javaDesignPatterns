package com.cl.dataStructures.stack;

/**
 * Created by cl on 2017/9/12.
 */
public class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long value) {
        stackArray[++top] = value;
    }

    public long pop() {
        return stackArray[top--];
    }

    public long peck() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        StackX stackX = new StackX(10);
        stackX.push(10);
        stackX.push(20);
        stackX.push(30);
        stackX.push(40);
        stackX.push(50);

        while (!stackX.isEmpty()){
            System.out.println(stackX.pop());
        }
    }
}
