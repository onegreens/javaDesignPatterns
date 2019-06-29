package com.cl.dataStructures.queue;

/**
 * Created by cl on 2017/9/12.
 * 基础队列
 *
 */
public class Queue {
    private int maxSize;
    private int front;//队头
    private int rear;//队尾
    private int nItems;
    private long[] queArray;

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(long value) {
        if (rear == maxSize - 1)
            rear = -1;
        queArray[++rear] = value;
        nItems++;
    }

    public long remove() {
        long temp = queArray[front++];
        if (front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public long peekFront() {
        return queArray[front];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public int getSize() {
        return nItems;
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);

        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(5);
        queue.insert(6);
        queue.insert(7);

        while (!queue.isEmpty())
            System.out.println(queue.remove());
    }
}
