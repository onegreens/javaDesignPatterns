package com.cl.interview.FileOperation.fo3;

import java.io.UnsupportedEncodingException;

/**
 * Created by cl on 2018/1/15.
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，
 * 输出为按字节截取的字符串，但要保证汉字不被截取半个，
 * 如“我ABC”，4，应该截取“我AB”，输入“我ABC汉DEF”，
 * 6，应该输出“我ABC”，而不是“我ABC+汉的半个”
 */
public class FileOperation3 {
    static void method(String str, int num) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes("GBK");
        boolean isChinese = false;
        int size = 0;
        for (int i = 0; i < num; i++) {
            if (bytes[i] < 0 && !isChinese) {//汉字占两个字节，当前单个字节若是汉字，则无法显示 即 bytes[i] < 0
                isChinese = true;
            } else {
                size++;
                isChinese = false;
            }
        }
        System.out.println(str.substring(0, size));
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你q1";
        method(s, 3);
    }
}
