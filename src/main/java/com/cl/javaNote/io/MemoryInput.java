package com.cl.javaNote.io;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by cl on 2017/9/7.
 * 从内存中输出
 *
 * 从BufferedInputFile.read()读入的String结果被用来创建一个StringReader.
 * 然后调用read()每次读取一个字符
 *
 * 区别于：BufferedReader 读取一行字符串
 * StringReader 读取一个字符
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader(BufferedInputFile.read("target\\classes\\ext.dic"));
        int c;
        //只读取一个字符
        while ((c = reader.read()) != -1)
            System.out.println((char) c);
    }
}
