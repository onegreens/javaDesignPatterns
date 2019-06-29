package com.cl.leetcode.simple.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * s = "abcd"
 * t = "abcde"
 * <p>
 * 输出：
 * e
 * <p>
 * 解释：
 * 'e' 是那个被添加的字母。
 */
public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }

    public static char findTheDifference(String s, String t) {
        int lens = s.length();
        if (lens > 0) {
            Map<String, Integer> sMap = new HashMap<>();
            for (int i = 0; i < lens; i++) {
                String str = String.valueOf(s.charAt(i));
                Integer num = sMap.get(str);
                if (num == null) {
                    sMap.put(str, 1);
                } else {
                    sMap.put(str, 1 + num);

                }
            }
            Map<String, Integer> tMap = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                String str = String.valueOf(t.charAt(i));
                Integer num = tMap.get(str);
                if (num == null) {
                    tMap.put(str, 1);
                } else {
                    tMap.put(str, 1 + num);
                }
            }
            for (String key : sMap.keySet()) {
                if (sMap.get(key) != tMap.get(key)) {
                    return key.charAt(0);
                }
            }
        }
        return t.charAt(lens);
    }
}
