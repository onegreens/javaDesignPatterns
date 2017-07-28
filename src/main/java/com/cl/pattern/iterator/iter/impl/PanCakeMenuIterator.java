package com.cl.pattern.iterator.iter.impl;

import com.cl.pattern.iterator.entity.MenuItem;
import com.cl.pattern.iterator.iter.Iterator;

import java.util.ArrayList;

/**
 * Created by cl on 2017/7/22.
 * 具体的迭代器
 */
public class PanCakeMenuIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;

    public PanCakeMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position >= items.size() || items.get(position) == null) {
            return false;
        }
        return true;
    }

    public Object next() {
        MenuItem menuItem = items.get(position);
        position++;
        return menuItem;
    }
}
