package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 */
public class LinkQueue {
    private FirstLastLink link;

    public LinkQueue() {
        this.link = new FirstLastLink();
    }

    public boolean isEmpty() {
        return link.isEmpty();
    }

    public void insert(long value) {
        link.insertLast(value);
    }

    public long remove() {
        return link.deleteFirst();
    }

    public void display() {
        link.display();
    }

    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.insert(10);
        linkQueue.insert(20);
        linkQueue.insert(30);
        linkQueue.insert(40);
        linkQueue.insert(50);
        linkQueue.display();
    }
}
