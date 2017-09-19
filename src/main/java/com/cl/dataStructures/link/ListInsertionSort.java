package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 * 将一个无序数组转为有序链表
 */
public class ListInsertionSort {
    public static void test2() {
        SortedList sortedList = new SortedList();
        int size = 10;
        Link[] link2s = new Link[size];

        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 99);
            link2s[i] = new Link(n);
        }

        for (int i = 0; i < size; i++) {
            System.out.println(link2s[i].lData);
        }
        System.out.println(" ");

        sortedList.insertByList(link2s);
        sortedList.display();
    }

    public static void main(String[] args) {
        ListInsertionSort.test2();
    }
}
