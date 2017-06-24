package com.work.search;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by cl on 2017/6/23.
 */
public class StringUtilTest {

    public static String checkString(String str) {
        Pattern p = Pattern.compile("[a-zA-z]");
        if (p.matcher(str).find()) {
            System.out.println("含有英文字符");
        } else {
            System.out.println("不含英文字符");
        }
        return null;
    }

    public static String[] splitString(String str) {
        String[] s=str.split("");
        for (String sss: s){
            System.out.println(s);
        }
        return s;
    }

    public static void main(String[] args) {
        StringUtilTest.splitString("是的dg");
    }
}
