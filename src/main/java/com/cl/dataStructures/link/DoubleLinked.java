package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 */
public class DoubleLinked {

    public static void main(String[] args) {
        DoubleLinkedList linkedList = new DoubleLinkedList();

        linkedList.insertFirst(11);
        linkedList.insertFirst(22);
        linkedList.insertFirst(33);
        linkedList.insertFirst(44);
        linkedList.insertLast(88);
        linkedList.insertLast(77);
        linkedList.insertLast(66);
        linkedList.insertLast(55);

        linkedList.displayForward();
        linkedList.displayBackward();

        linkedList.deleteFirst();
        linkedList.deleteLast();
        linkedList.deleteKey(55);

        linkedList.insertAfter(11, 12);
        linkedList.insertAfter(12, 13);

        linkedList.displayForward();

    }
}

class DoubleLinkedList {
    public DLink first;
    public DLink last;

    public DoubleLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(long iData) {
        DLink newLink = new DLink(iData);
        if (isEmpty())
            last = newLink;
        else
            first.previous = newLink;
        newLink.next = first;
        first = newLink;
    }

    public void insertLast(long iData) {
        DLink newLink = new DLink(iData);
        if (isEmpty())
            first = newLink;
        else {
            last.next = newLink;
            newLink.previous = last;
        }
        last = newLink;
    }

    public long deleteFirst() {
        long temp = first.dData;
        if (first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return temp;
    }

    public long deleteLast() {
        long temp = last.dData;
        if (first.next == null)
            last = null;
        else
            last.previous.next = null;
        last = last.previous;
        return temp;
    }

    public boolean insertAfter(long key, long value) {
        DLink current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return false;
        }
        DLink newLink = new DLink(value);
        if (current == last) {
            newLink.next = null;
            last = newLink;
        } else {
            newLink.next = current.next;
            current.next.previous = newLink;
        }
        newLink.previous = current;
        current.next = newLink;
        return true;
    }

    public DLink deleteKey(long key) {
        DLink current = first;
        while (current.dData != key) {
            current = current.next;
            if (current == null)
                return null;
        }
        if (current == first)
            first = current.next;
        else
            current.previous.next = current.next;

        if (current == last)
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    public void displayForward() {
        System.out.println("List (first -> last ):");
        DLink current = first;
        while (current != null) {
            current.dispaly();
            current = current.next;
        }
        System.out.println(" ");
    }

    public void displayBackward() {
        System.out.println("List (first -> last ):");
        DLink current = last;
        while (current != null) {
            current.dispaly();
            current = current.previous;
        }
        System.out.println(" ");
    }


}
