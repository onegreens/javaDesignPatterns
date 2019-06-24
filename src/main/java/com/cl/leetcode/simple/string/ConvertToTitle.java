package com.cl.leetcode.simple.string;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 * <p>
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 * <p>
 * 输入: 701
 * 输出: "ZY"
 */
public class ConvertToTitle {
    public static void main(String[] args) {
//        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(702));
//        System.out.println(convertToTitle(28));
//        System.out.println(convertToTitle(1701));
    }

    public static String convertToTitle(int s) {
        if (s < 1)
            return "";
        String[] strings = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String result = "";
        int size = 0;
        while (s > 26) {
            int m = s % 26;
            if (m == 0) {
                result = strings[25 - size] + result;
                size = 1;
            } else {
                if (m - 1 - size < 0) {
                    result = strings[25] + result;
                    s = s / 26;
                } else {
                    result = strings[m - 1 - size] + result;
                }
                size = 0;
            }
            s = s / 26;
        }
        if (s - 1 - size > -1) {
            result = strings[s - 1 - size] + result;
        }
        return result;
    }
}
