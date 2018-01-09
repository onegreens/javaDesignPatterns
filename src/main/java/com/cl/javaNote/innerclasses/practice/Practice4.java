package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 在Sequence,SequenceSelector类中增加一个方法，它可以生成对外部类Sequence的引用
 */
public class Practice4 {
    private Object[] items;
    private int next = 0;

    public Practice4(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    private class SequenceSelector implements Selector4 {
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

        public Practice4 outer(){
            return Practice4.this;
        }
    }
    public Selector4 selector() {
        return new Practice4.SequenceSelector();
    }

    public static void main1(String[] args) {
        Practice4 sequence = new Practice4(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector4 selector = sequence.selector();
//        selector.outer();由于向上转型 导致该方法无法调用
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }
}

interface Selector4 {
    boolean end();

    Object current();

    void next();
}
