package com.cl.dataStructures.queue;

/**
 * Created by cl on 2017/9/12.
 * 优先级队列
 * 值小优先
 */
public class PriorityQueue {
    private int maxSize;
    private int nItems;
    private long[] queArray;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        queArray = new long[maxSize];
        nItems = 0;
    }

    public void insert(long value) {
        int j;

        if (nItems == 0)
            queArray[nItems++] = value;
        else {
            for (j = nItems - 1; j >= 0; j--)
                if (value > queArray[j])
                    queArray[j + 1] = queArray[j];
                else
                    break;
            queArray[j + 1] = value;
            nItems++;
        }
    }

    public long remove() {
        return queArray[--nItems];
    }

    public long peekMin() {
        return queArray[nItems - 1];
    }

    public boolean isEmpty() {
        return (nItems == 0);
    }

    public boolean isFull() {
        return (nItems == maxSize);
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(5);
        queue.insert(2);
        queue.insert(3);
        queue.insert(1);

        queue.insert(4);

        while (!queue.isEmpty())
            System.out.println(queue.remove());

    }
}
