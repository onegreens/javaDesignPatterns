package com.cl.interview.FileOperation.fo4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by cl on 2018/1/15.
 * 从类似如下的文本文件中读取出所有的姓名，并打印出重复的姓名和重复的次数，并按重复次数排序：
 *
 1,张三,28
 2,李四,35
 3,张三,28
 4,王五,35
 5,张三,28
 6,李四,35
 7,赵六,28
 8,田七,35
 */
public class FileOperation4 {
    static void method() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("testFile/fo4/test.txt"));
        Map<String,Integer> map = new TreeMap<String, Integer>();
        String s ;
        while ((s= reader.readLine())!=null){
            String[] strings1 = s.split(",");
            String name = strings1[1];
            if (map.get(name)==null){
                map.put(name,1);
            }else {
                map.put(name,map.get(name)+1);
            }
        }
        for (String key:map.keySet()
             ) {
            System.out.println(key+":"+map.get(key));

        }
    }

    public static void main(String[] args) throws IOException {
        method();
    }
}
