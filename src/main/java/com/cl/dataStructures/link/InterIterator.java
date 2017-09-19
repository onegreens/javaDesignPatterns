package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 */
public class InterIterator {

    public InterIterator(IterLinkList linkList) {
        this.ourList = linkList;
        reset();
    }

    private Link current;
    private Link previous;
    private IterLinkList ourList;

    public void reset() {
        current = ourList.getFirst();
        previous = null;
    }

    boolean atEnd() {
        return current.next == null;
    }

    void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    void insertAfter(long value) {
        Link newLink = new Link(value);

        if (ourList.isEmpty()) {
            ourList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    void insertBefore(long value) {
        Link newLink = new Link(value);

        if (previous == null) {
            newLink.next = ourList.getFirst();
            ourList.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    long deleteCurrent() {
        long value = current.lData;
        if (previous == null) {
            ourList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd())
                reset();
            else
                current = current.next;
        }
        return value;
    }

    public static void main(String[] args) {
        IterLinkList linkList = new IterLinkList();
        InterIterator interIterator = linkList.getIterator();

        interIterator.insertAfter(20);
        interIterator.insertAfter(30);
        interIterator.insertAfter(40);
        interIterator.insertBefore(50);

        interIterator.ourList.display();
    }
}

class IterLinkList {
    private Link first;

    public IterLinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public InterIterator getIterator() {
        return new InterIterator(this);
    }

    /**
     * 遍历显示
     */
    public void display() {
        System.out.println("List (first -> last ):");
        Link current = first;
        while (current != null) {
            current.displayLData();
            current = current.next;
        }
        System.out.println(" ");
    }
}
