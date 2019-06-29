package com.cl.leetcode.arithmetic.simple.string;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b) {
        String result = "";
        int index = 1;
        String one = "1";
        String zero = "0";
        int lena = a.length();
        int lenb = b.length();
        String item = "";
        boolean add = false;
        while (index <= Math.max(lena, lenb)) {
            char stra = '0';
            if (lena >= index)
                stra = a.charAt(lena - index);
            char strb = '0';
            if (lenb >= index)
                strb = b.charAt(lenb - index);
            if (stra == '1' && strb == '1') {
                item = zero;
                if (add) {
                    item = one;
                }
                add = true;
            } else if (stra == '0' && strb == '0') {
                item = zero;
                if (add) {
                    item = one;
                }
                add = false;
            } else {
                item = one;
                if (add) {
                    item = zero;
                    add = true;
                }
            }
            result = item + result;
            index++;
        }
        if (add)
            result = one + result;
        return result;
    }
}
