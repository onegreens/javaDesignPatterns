package com.cl.pattern.iterator.iter.impl;

import com.cl.pattern.iterator.entity.MenuItem;
import java.util.Iterator;

/**
 * Created by cl on 2017/7/22.
 * 具体的迭代器
 */
public class DinnerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        MenuItem menuItem = items[position];
        position++;
        return menuItem;
    }

    public void remove() {
        if (position <= 0) {
            System.out.println("没有更多的数据了");
        }
        if (items[position - 1] != null) {
            for (int i = position - 1; i < items.length - 1; i++) {
                items[i] = items[i + 1];
            }
            items[items.length-1] = null;
        }
    }
}
