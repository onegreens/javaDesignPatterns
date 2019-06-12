package com.cl.leetcode.simple;

/**
 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。

 如果不存在最后一个单词，请返回 0 。

 说明：一个单词是指由字母组成，但不包含任何空格的字符串。

 示例:

 输入: "Hello World"
 输出: 5
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("aa aa  "));
        System.out.println(lengthOfLastWord2("a a  "));
    }


    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int index = 0;
        int num = 0;
        boolean block = false;
        while (index < len) {
            if (s.charAt(index) == ' ') {
                block = true;
            } else {
                if (block) {
                    num = 1;
                } else {
                    num++;
                }
                block = false;
            }
            index++;
        }
        return num;
    }

    public static int lengthOfLastWord2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] strings = s.split(" ");
        if (strings.length == 0)
            return 0;
        return strings[strings.length - 1].length();
    }
}
