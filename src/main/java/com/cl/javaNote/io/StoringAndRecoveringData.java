package com.cl.javaNote.io;

import java.io.*;

/**
 * Created by cl on 2017/9/7.
 * 存储和恢复数据
 *
 * DataOutputStream 输出
 * DataInputStream 输入
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("fileNote/data.txt")
                )
        );
        outputStream.writeDouble(3.1414);
        outputStream.writeUTF("THAT IS PI");
        outputStream.writeDouble(1.156);
        outputStream.writeUTF("THAT IS not a PI");
        outputStream.close();
        DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("fileNote/data.txt")
                )
        );
        System.out.println(inputStream.readDouble());
        System.out.println(inputStream.readUTF());
        System.out.println(inputStream.readDouble());
        System.out.println(inputStream.readUTF());
    }
}
