package com.cl.javaNote.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cl on 2017/9/7.
 * 缓冲输入文件
 * 读取文件内容
 * <p>
 * BufferedReader 对应 BufferedInputStream
 * 可以防止每次读取时都得进行实际写操作。代表使用缓冲区
 */
public class BufferedInputFile {
    public static String read(String filename) throws IOException {
        //filename的路径是在当前文件javaDesignPatterns目录下的文件
        //BufferedReader起到缓冲作用
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder builder = new StringBuilder();
        //利用BufferedReader的readLine()方法进行内容读取
        while ((s = reader.readLine()) != null) {
            builder.append(s + "\n");
        }
        reader.close();
        return builder.toString();
    }

    public static String read(File file) throws IOException {
        //filename的路径是在当前文件javaDesignPatterns目录下的文件
        //BufferedReader起到缓冲作用
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        StringBuilder builder = new StringBuilder();
        //利用BufferedReader的readLine()方法进行内容读取
        while ((s = reader.readLine()) != null) {
            builder.append(s + "\n");
        }
        reader.close();
        return builder.toString();
    }
    public static List<String> readToList(File file) throws IOException {
        //filename的路径是在当前文件javaDesignPatterns目录下的文件
        //BufferedReader起到缓冲作用
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        List<String> builder = new ArrayList<>();
        //利用BufferedReader的readLine()方法进行内容读取
        while ((s = reader.readLine()) != null) {
            builder.add(s);
        }
        reader.close();
        return builder;
    }

    public static void main(String[] args) throws IOException {
//        System.out.println(read("src/main/java/com/cl/javaNote/io/catalog.md"));
//        System.out.println(read("src\\main\\resources\\ext.dic"));
        System.out.println(read("target\\classes\\ext.dic"));
    }
}
