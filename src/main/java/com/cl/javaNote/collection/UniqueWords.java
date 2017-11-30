package com.cl.javaNote.collection;

import com.cl.javaNote.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by cl on 2017/9/25.
 * TextFile 工具
 * 打开一个文件，并将它读入set中
 */
public class UniqueWords {
    public static void main(String[] args) {
        Set<String> words = new TreeSet<String>(
                //读取文件并根据正则断开为单词
                new TextFile("src/main/java/com/cl/javaNote/collection/SetOfInteger.java", "\\W+"));
        System.out.println(words);
    }
}
