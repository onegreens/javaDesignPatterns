package com.cl.javaNote.generics.generator;

import java.util.Iterator;

/**
 * Created by cl on 2017/12/16.
 */
public class FibonacciIterator extends Fibonacci implements Iterable<Integer> {
    int size;
    public FibonacciIterator(int size) {
        this.size = size;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return size > 0;
            }

            public Integer next() {
                size--;
                return FibonacciIterator.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();

            }
        };
    }


}
