package com.cl.interview.FileOperation.fo1;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by cl on 2018/1/15.
 * 将a.txt文件中的单词和b.txt文件中的单词交替合并到c.txt，文件中
 * a.txt文件中的单词用回车分隔
 * b.txt文件中的单词用空格分隔
 */
public class FileOperation1 {
    static final String base = "testFile/fo1/";
    static final String aPath = base + "a.txt";
    static final String bPath = base + "b.txt";
    static final String cPath = base + "c.txt";

    static void method1() throws IOException {
        BufferedReader readera = new BufferedReader(new FileReader(aPath));
        List<String> aStrs = new ArrayList<String>();
        String s;
        while ((s = readera.readLine()) != null)
            aStrs.add(s);

        BufferedReader readerb = new BufferedReader(new FileReader(bPath));
        List<String> bStrs = new ArrayList<String>();
        while ((s = readerb.readLine()) != null) {
            String[] strings = s.split(" ");
            for (String str : strings) {
                bStrs.add(str);
            }
        }
        Iterator<String> aIterator = aStrs.iterator();
        Iterator<String> bIterator = bStrs.iterator();


        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(cPath)));
        while (true) {
            boolean aBoolean = aIterator.hasNext();
            if (aBoolean) {
                writer.write(aIterator.next());
            }
            boolean bBoolean = bIterator.hasNext();
            if (bBoolean) {
                writer.write(bIterator.next());
            }
            if (aBoolean == false && bBoolean == false)
                break;
        }
        writer.close();
        readera.close();

    }

    public static void main(String[] args) throws IOException {
        method1();
    }
}
