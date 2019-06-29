package com.cl.leetcode.arithmetic.simple.string;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class CanConstruct {
    public static void main(String[] args) {
        System.out.println(canConstruct("a", "b"));
        System.out.println(canConstruct("aa", "ab"));
        System.out.println(canConstruct("aa", "aab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length())
            return false;
        if (magazine.indexOf(ransomNote) > -1) return true;
        String[] strs = ransomNote.split("");
        List<String> list = Arrays.asList(magazine.split(""));
        for (int i = 0; i < strs.length; i++) {
            int index = list.indexOf(strs[i]);
            if (index == -1)
                return false;
            list.set(index, "");
        }
        return true;
    }
}
