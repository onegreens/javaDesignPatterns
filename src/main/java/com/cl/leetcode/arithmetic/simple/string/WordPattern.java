package com.cl.leetcode.arithmetic.simple;

import com.cl.dataStructures.array.Array;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
 */
public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("", "deee"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] patterns = pattern.split("");
        String[] strs = str.split(" ");
        List<String> patternList = Arrays.asList(patterns);
        List<String> strList = Arrays.asList(strs);
        if(strList.size()!=patternList.size())return false;
        if(pattern.length()==0 &&str.length()!=0)return false;
        for (int i = 0; i < patterns.length; i++) {
            String wordp = patterns[i];
            if("".equals(wordp))continue;
            String words = strs[i];
            patternList.set(i, "");
            strList.set(i, "");
            while (true) {
                int indexp = patternList.indexOf(wordp);
                int indexs = strList.indexOf(words);
                if(indexp!=indexs)
                    return false;
                if(indexp!=-1){
                    patternList.set(indexp, "");
                    strList.set(indexs, "");
                }else {
                    break;
                }
            }
        }
        return true;
    }

    public static boolean wordPattern1(String pattern, String str) {
        String[] patterns = pattern.split("");
        String[] strs = str.split(" ");
        if (patterns.length != strs.length)
            return false;
        if (pattern.length() < 2) return true;
        int exist = 0;
        for (int i = 0; i < patterns.length - 1; i++) {
            for (int j = 1; j < patterns.length; j++) {
                if (patterns[i].equals(patterns[j])) {
                    if (!strs[i].equals(strs[j])) return false;
                } else {
                    if (strs[i].equals(strs[j])) return false;
                    if (exist == 0) exist = j;
                }
            }
            if (exist == 0) break;
            else {
                i = exist;
                exist = 0;
            }
        }
        return true;
    }
}
