package com.cl.javaNote.containers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cl on 2017/10/7.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        list2.addAll(list);
        list.add(2);
        list.add(2);
        list.add(2);
        System.out.println(list2.size());

    }
}
