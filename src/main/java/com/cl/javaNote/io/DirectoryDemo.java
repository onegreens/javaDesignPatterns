package com.cl.javaNote.io;

import com.cl.javaNote.util.PPrint;

import java.io.File;
import static com.cl.javaNote.util.Print.*;

/**
 * Created by cl on 2017/9/5.
 * 将Directory作为工具使用
 */
public class DirectoryDemo {
    public static void main(String[] args) {
        // All directories:
        PPrint.pprint(Directory.walk(".").dirs);
        // All files beginning with 'T'
        for(File file : Directory.local(".", "T.*"))
            print(file);
        print("----------------------");
        // All Java files beginning with 'T':
        for(File file : Directory.walk(".", "T.*\\.java"))
            print(file);
        print("======================");
        // Class files containing "Z" or "z":
        for(File file : Directory.walk(".",".*[Zz].*\\.class"))
            print(file);
    }
}
