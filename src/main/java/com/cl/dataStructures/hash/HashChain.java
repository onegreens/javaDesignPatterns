package com.cl.dataStructures.hash;

/**
 * Created by cl on 2017/9/21.
 */
public class HashChain {
    private SortedList[] hashArray;
    private int arraySize;

    public HashChain(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i < arraySize; i++) {
            hashArray[i] = new SortedList();
        }
    }

    void display() {
        for (int i = 0; i < arraySize; i++) {
            System.out.print(i + ". ");
            hashArray[i].display();
        }
    }

    int hashFunc(int key) {//hash函数
        return key % arraySize;
    }

    void insert(Link theLink) {
        int hashVal = hashFunc(theLink.getiData());
        hashArray[hashVal].insert(theLink);
    }

    void delete(int key) {
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    Link find(int key){
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }


    public static void main(String[] args) {
        HashChain hash = new HashChain(50);
        for (int i = 0; i < 40; i++) {
            hash.insert(new Link((int) (Math.random() * 20)));
        }
        hash.display();
    }

}

class Link {
    private int iData;
    Link next;

    public Link(int iData) {
        this.iData = iData;
    }

    public int getiData() {
        return iData;
    }

    @Override
    public String toString() {
        return "Link{" +
                "iData=" + iData +
                '}';
    }
}

class SortedList {
    private Link first;

    public SortedList() {
        first = null;
    }

    void insert(Link theLink) {
        int key = theLink.getiData();
        Link pre = null;
        Link current = first;

        while (current != null && key != current.getiData()) {
            pre = current;
            current = current.next;
        }
        if (pre == null)
            first = theLink;
        else
            pre.next = theLink;
        theLink.next = current;
    }

    void delete(int key) {
        Link pre = null;
        Link current = first;

        while (current != null && key != current.getiData()) {
            pre = current;
            current = current.next;
        }
        if (pre != null)
            first = first.next;
        else
            pre.next = current.next;
    }

    Link find(int key) {
        Link current = first;
        while (current != null && current.getiData() != key) {
            if (current.getiData() == key)
                return current;
            current = current.next;
        }
        return null;
    }

    void display() {
        System.out.print("List (first --> last):");
        Link current = first;
        while (current != null) {
            System.out.print(" " + current.toString());
            current = current.next;
        }
        System.out.println();
    }
}
