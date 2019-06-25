package com.cl.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int len = 0;
        String[] strings = s.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            Integer num = map.get(strings[i]);
            if (num == null) {
                map.put(strings[i], 1);
            } else {
                map.put(strings[i], num + 1);
            }
        }
        for (String key : map.keySet()) {
            len += map.get(key) / 2;
        }
        len *= 2;
        if (len < strings.length)
            len += 1;
        return len;
    }
}
