package com.cl.leetcode.arithmetic.simple.string;

/**
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 */
public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
//        if(s==null&&t==null)
//            return true;
//        if(s==null)
//            return false;
//        if(t==null)
//            return false;
        int len = s.length();
        if (len < 2)
            return true;
        int[] same = new int[len / 2];
        int sames = 0;

        for (int i = 0; i < len; i++) {
            char words = s.charAt(i);
            char wordt = t.charAt(i);
            for (int j = i + 1; j < len; j++) {
                char words_ = s.charAt(j);
                char wordt_ = t.charAt(j);
                if (words != words_ && wordt == wordt_) {
                    return false;
                }
                if (words == words_ && wordt != wordt_) {
                    return false;
                }
            }
        }
        return true;
    }
}
