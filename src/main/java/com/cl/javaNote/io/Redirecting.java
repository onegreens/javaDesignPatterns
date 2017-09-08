package com.cl.javaNote.io;

import java.io.*;

/**
 * Created by cl on 2017/9/8.
 * 标准I/O重定向
 *
 * 将标准输出附接到文件上，并将标准输出和标准错误从定向到另一个文件
 *
 * I/O重定向操作的是字节流，而不是字符流。
 * 因此使用InputStream和OutputStream，而不是Reader和Writer
 *
 */
public class Redirecting {
    public static void main(String[] args) throws IOException, InterruptedException {
        PrintStream console = System.out;//存储了对System.out对象的引用
        BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("fileNote/test.md"));
        PrintStream out = new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream("fileNote/data.txt")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null)
            System.out.println(s);
        out.close(); // Remember this!
        System.setOut(console);//将系统输出恢复到System.out对象上
    }
}
