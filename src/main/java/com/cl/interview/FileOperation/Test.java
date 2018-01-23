package com.cl.interview.FileOperation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by cl on 2018/1/18.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File dir = new File("testdir/aaa/bbb");
        if (!dir.exists())
            dir.mkdirs();
        File file = new File("testdir/aaa/bbb/test111.txt");
        if (!file.exists())
            file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        String s = "你好";
        byte[] bytes = s.getBytes("UTF-8");
        outputStream.write(bytes);
        outputStream.close();
    }
}
