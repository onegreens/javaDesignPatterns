package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 * 双端链表
 * 特性:对最后一个链节点的引用，允许其向在表头一样，在表位直接插入一个链节点
 */
public class FirstLastLink {
    private Link first;
    private Link last;

    public FirstLastLink() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long iData) {
        Link newLink = new Link(iData);
        if (isEmpty())
            last = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long iData) {
        Link newLink = new Link(iData);
        if (isEmpty())
            first = newLink;
        else
            last.next = newLink;
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.lData;
        if (first.next == null)
            last = null;
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
        FirstLastLink thisLink = new FirstLastLink();

        thisLink.insertFirst(1);
        thisLink.insertFirst(2);
        thisLink.insertFirst(3);
        thisLink.insertFirst(4);
        thisLink.insertLast(5);
        thisLink.insertLast(6);
        thisLink.insertLast(7);
        thisLink.insertLast(8);

        thisLink.display();

        thisLink.deleteFirst();
        thisLink.deleteFirst();
        thisLink.deleteFirst();

        thisLink.display();

    }

    public static void test2() {
        Link newLink = new Link(1);
        Link newLink2 = newLink;
        newLink.lData = 2;
        newLink2.displayLData();
        //该证明在链表中都是都引用地址的改写 并没有创建新的对象

    }

        public static void main(String[] args) {
//        FirstLastLink.test1();
        FirstLastLink.test2();
    }

}


