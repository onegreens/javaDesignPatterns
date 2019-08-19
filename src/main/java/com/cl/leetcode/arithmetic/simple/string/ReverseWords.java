package com.cl.leetcode.arithmetic.simple.string;

/**
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc" 
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
    public static String reverseWords(String s) {
        String str = "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            if (index == ' ') {
                result += str + index;
                str = "";
            } else {
                str = index+str;
            }
        }
        result += str;
        return result;

    }
}
