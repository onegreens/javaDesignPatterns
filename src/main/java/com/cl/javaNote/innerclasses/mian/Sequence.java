package com.cl.javaNote.innerclasses.mian;//: innerclasses/Sequence.java
// Holds a sequence of Objects.

import com.cl.javaNote.innerclasses.practice.Practice2;

interface Selector {
    boolean end();

    Object current();

    void next();
}

/**
 * 内部类自动拥有对其外部类的所有成员的访问权
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public static void main1(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
    public static void main(String[] args) {
        //Practice2
        Sequence sequence = new Sequence(5);
        sequence.add(new Practice2("test1"));
        sequence.add(new Practice2("test2"));
        sequence.add(new Practice2("test3"));
        sequence.add(new Practice2("test4"));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
} /* Output:
0 1 2 3 4 5 6 7 8 9
*///:~
