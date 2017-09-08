package com.cl.javaNote.io;

import java.io.*;

/**
 * Created by cl on 2017/9/7.
 * 基本的文件输出
 *
 * PrintWriter
 */
public class BasicFileOutput {
    static String file = "fileNote/BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        //利用BufferedReader包装缓冲
        BufferedReader reader = new BufferedReader(
                new StringReader(
                        BufferedInputFile.read("fileNote/test.md")
                )
        );
        //创建一个和指定文件链接的FileWriter
        //为了提供格式化机制，则使用PrintWriter
        //按照这种方式创建的数据文件可以作文普通文本文件读取
        PrintWriter writer = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(file)));
        String s;
        int lineCount = 1;
        while ((s = reader.readLine()) != null)
            writer.write(lineCount++ + ":" + s);
        //如果不为writer调用close()，则缓冲区内容不会被刷新清空
        writer.close();
        System.out.println(BufferedInputFile.read(file));
    }

    /**
     * 添加辅助构造器
     */
    public void test() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
    }
}
