package com.cl.leetcode.arithmetic.simple.string;

import com.cl.dataStructures.array.Array;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 “T 能除尽 S”。
 * <p>
 * 返回字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * 示例 2：
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * 示例 3：
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] 和 str2[i] 为大写英文字母
 */
public class GcdOfStrings {
    public static void main(String[] args) {

        //TODO
        System.out.println(gcdOfStrings("ABCABCABCABC", "ABCABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        List<String> list = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < str2.length(); i++) {
            str.append(str2.charAt(i));
            String str2_ = str2;
            String val = str.toString();
            while (str2_.contains(val)) {
                str2_ = str2_.replace(val, "");
            }
            if ("".equals(str2_)) list.add(val);
        }
        for (int i = list.size() - 1; i > -1; i--) {
            String val = list.get(i);
            while (str1.contains(val)) {
                str1 = str1.replace(val, "");
            }
            if ("".equals(str1)) return val;
        }
        return "";

    }
}
