package com.cl.javaNote.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by cl on 2017/9/8.
 * 从标准输入中读取
 *
 * 直接回显输入的字符
 *
 * 将System.in 包装成 BufferedReader
 * 前提是 使用InputStreamReader将System.in 转换成 Reader
 *
 * System.in 是一个没有被包装过的未加工的InputStream
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)//转换
        );
        String s;
        while ((s = reader.readLine()) != null && s.length() != 0)
            System.out.println(s);
    }
}
