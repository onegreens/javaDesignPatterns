package com.cl.interview.FileOperation.fo2;

import org.apache.tools.ant.types.FileList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by cl on 2018/1/15.
 * 将/java目录下的所有.java复制到/jad目录下，并将文件扩展名修改为.jad
 */
public class FileOperation2 {
    public static void main(String[] args) throws Exception {
        File srcDir = new File("testFile/fo2/java");
        if (!(srcDir.exists() && srcDir.isDirectory()))
            throw new Exception("目录不存在");
        File[] lists = srcDir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });


        File destDir = new File("testFile/fo2/jad");
        if(destDir.exists())
            destDir.mkdir();
        for (File file : lists){
            FileInputStream inputStream = new FileInputStream(file);
            String fileDestName = file.getName().replaceAll("\\.java",".jad");
            FileOutputStream outputStream = new FileOutputStream(new File(destDir,fileDestName));
            int len = 0;
            byte[] buf = new byte[1024];
            while((len = inputStream.read(buf)) !=-1){
                outputStream.write(buf,0,len);
            }
            inputStream.close();
            outputStream.close();
        }
    }

}
