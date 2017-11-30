package com.cl.javaNote.collection;

import com.cl.javaNote.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cl on 2017/9/25.
 * 根据字母表排序
 * 为TreeSet设置排序规则
 */
public class UniqueWordsAlphabetic {
    public static void main(String[] args) {
        Set<String> words =
                new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
        words.addAll(
                new TextFile("src/main/java/com/cl/javaNote/collection/SetOfInteger.java", "\\W+"));
        System.out.println(words);
    }
}
