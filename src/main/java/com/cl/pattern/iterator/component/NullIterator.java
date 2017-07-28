package com.cl.pattern.iterator.component;

import java.util.Iterator;

/**
 * Created by cl on 2017/7/27.
 */
public class NullIterator implements Iterator {
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        return null;
    }

    public void remove() {

    }
}
