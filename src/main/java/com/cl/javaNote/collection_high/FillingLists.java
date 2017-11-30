package com.cl.javaNote.collection_high;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cl on 2017/9/27.
 * 两种对单个对象的引用来填充Collection的方式
 * nCopies：
 * fill：只能替换存在的元素而不能添加新的元素
 */
class StringAddress {
    private String s;
    public StringAddress(String s) { this.s = s; }
    public String toString() {
        return super.toString() + " " + s;
    }
}

public class FillingLists {
    public static void main(String[] args) {
        List<StringAddress> list= new ArrayList<StringAddress>(
                Collections.nCopies(4, new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list, new StringAddress("World!"));
        System.out.println(list);
    }
}
