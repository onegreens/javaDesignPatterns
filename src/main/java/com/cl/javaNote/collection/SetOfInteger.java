package com.cl.javaNote.collection;

import java.util.*;

/**
 * Created by cl on 2017/9/22.
 * 不允许存在重复元素
 * 使用存放Integer对象HashSet及TreeSet的实例
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);

        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++)
            intset.add(rand.nextInt(30));
        System.out.println(intset);

        SortedSet<Integer> intsetSort = new TreeSet<Integer>();
        for(int i = 0; i < 10000; i++)
            intsetSort.add(rand.nextInt(30));
        System.out.println(intsetSort);
    }
}
