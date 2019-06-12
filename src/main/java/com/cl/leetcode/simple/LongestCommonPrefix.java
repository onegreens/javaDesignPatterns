package com.cl.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        List compare = null;
        for (int i = 0; i < strs.length; i++) {
            String item = strs[i];
            String[] items = item.split("");
            if (compare == null) {
                compare = Arrays.asList(items);
            } else {
                List common = new ArrayList();
                int minLen = Math.min(compare.size(), items.length);
                for (int j = 0; j < minLen; j++) {
                    if (items[j].equals(compare.get(j))) {
                        common.add(items[j]);
                    } else {
                        break;
                    }
                }
                compare = common;
                if (compare.size() == 0) {
                    break;
                }
            }
        }
        if (compare != null && compare.size() > 0) {
            String result = "";
            for (int i = 0; i < compare.size(); i++) {
                result += compare.get(i);
            }
            return result;
        }
        return "";
    }
}
