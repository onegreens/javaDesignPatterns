package com.cl.javaNote.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

/**
 * Created by cl on 2017/9/7.
 * 格式化内存输出
 *
 * 输出字节
 *
 * ByteArrayInputStream：允许将内存中的缓冲区当做InputStream使用
 * DataInputStream：按照可移植方式从流中读取基本数据类型 面向字节
 */
public class FormattedMemoryInput {
    public static void main(String[] args) throws IOException {
        try {
            DataInputStream stream =
                    new DataInputStream(
                            new ByteArrayInputStream(//用于传递InputStream
                                    BufferedInputFile.read("target\\classes\\ext.dic").getBytes()));
            while (true) {
                System.out.println(stream.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }

    /**
     * 改进输出控制
     * available(): 在没有阻塞的情况下所能读取的字节数
     * @param args
     * @throws IOException
     */
    public static void main1(String[] args) throws IOException {
        try {
            DataInputStream stream =
                    new DataInputStream(
                            new ByteArrayInputStream(
                                    BufferedInputFile.read("target\\classes\\ext.dic").getBytes()));
            while (stream.available() != 0) {//判断是否还有字符
                System.out.println(stream.readByte());
            }
        } catch (EOFException e) {
            System.err.println("End of stream");
        }
    }
}
