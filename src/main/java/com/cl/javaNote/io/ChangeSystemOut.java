package com.cl.javaNote.io;

import java.io.PrintWriter;

/**
 * Created by cl on 2017/9/8.
 * 将System.out 转换成 PrintWriter
 * System.out 是一个 PrintStream
 * System.err 是一个 PrintStream
 * PrintStream 是一个 OutputStream
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        // autoFlush =  true 开启自动清空
        PrintWriter out = new PrintWriter(System.out,true);
        out.println("hello world");
    }
}
