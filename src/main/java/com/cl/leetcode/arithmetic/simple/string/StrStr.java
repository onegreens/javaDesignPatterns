package com.cl.leetcode.arithmetic.simple;

/**
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("aaabba", "bba"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null)
            return -1;
        if (needle == null || needle.length() == 0)
            return 0;
        if (needle.length() == 0)
            return -1;
        int len = haystack.length();
        int len_ = needle.length();
        if (len < len_)
            return -1;
        int index = 0;
        while (index < (len - len_ + 1)) {
            String str = haystack.substring(index, index + len_);
            if (str.equals(needle)) {
                return index;
            }
            index++;
        }
        return -1;

    }
}
