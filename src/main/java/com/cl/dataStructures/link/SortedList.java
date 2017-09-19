package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 * 有序链表
 */
public class SortedList {
    private Link first;

    public SortedList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long key) {
        Link newLink = new Link(key);
        Link pre = null;
        Link current = first;
        while (current != null && key > current.lData) {
            pre = current;
            current = current.next;
        }
        if (pre == null)
            first = newLink;
        else
            pre.next = newLink;
        newLink.next = current;
    }

    /**
     * 将一个无序数组转为有序链表
     *
     * @param links
     */
    public void insertByList(Link[] links) {
        for (int i = 0; i < links.length; i++) {
            insertFirst(links[i].lData);
        }
    }

    public long remove() {
        long temp = first.lData;
        first = first.next;//当前节点退为下一个节点
        return temp;
    }

    public void display() {
        System.out.println("List (first -> last ):");
        Link current = first;
        while (current != null) {
            current.displayLData();
            current = current.next;
        }
        System.out.println(" ");
    }

    public static void test1() {
        SortedList sortedList = new SortedList();
        sortedList.insertFirst(1);
        sortedList.insertFirst(3);
        sortedList.insertFirst(2);
        sortedList.display();
    }

}
