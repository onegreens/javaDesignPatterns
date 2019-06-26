package com.cl.leetcode.simple.string;

import com.cl.dataStructures.array.Array;

import java.util.*;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * <p>
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 * <p>
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * <p>
 * 输出:
 * [0, 6]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 * <p>
 * 输入:
 * s: "abab" p: "ab"
 * <p>
 * 输出:
 * [0, 1, 2]
 * <p>
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class FindAnagrams {
    public static void main(String[] args) {
        //TODO
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams1("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        if (plen > slen) return list;
        String[] ps = p.split("");
        Map<String, Integer> pMap = new HashMap();
        for (int i = 0; i < plen; i++) {
            Integer num = pMap.get(ps[i]);
            if (num == null) {
                pMap.put(ps[i], 1);
            } else {
                pMap.put(ps[i], num + 1);
            }
        }
        Map<String, Integer> sMap = new HashMap();
        String[] ss = s.split("");

        boolean is = false;
        for (int i = 0; i < slen; i++) {
            int pre = i - plen;
            String cur = ss[i];
            if (i >= plen) {
                if (is) {
                    if (ss[pre].equals(cur)) {
                        list.add(pre + 1);
                        continue;
                    }
                }
                if (sMap.get(ss[pre]) == 1) {
                    sMap.remove(ss[pre]);
                } else {
                    sMap.put(ss[pre], sMap.get(ss[pre]) - 1);

                }
            }
            Integer num = sMap.get(cur);
            if (num == null) {
                sMap.put(cur, 1);
            } else {
                sMap.put(cur, num + 1);
            }
            if (i >= plen - 1) {
                if (sMap.equals(pMap)) {
                    list.add(pre + 1);
                    is = true;
                    continue;
                }
            }
            is = false;
        }
        return list;
    }

    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int slen = s.length();
        int plen = p.length();
        String[] ps = p.split("");
        List<String> plist = new ArrayList<>();

        for (int i = 0; i <= slen - plen; i++) {
            boolean is = true;
            plist.clear();
            plist.addAll(Arrays.asList(ps));
            for (int j = i; j < plen + i; j++) {
                int index = plist.indexOf(String.valueOf(s.charAt(j)));
                if (index > -1) {
                    plist.set(index, "");
                } else {
                    is = false;
                    break;
                }
            }
            if (is) {
                list.add(i);
            }
        }
        return list;
    }

}
