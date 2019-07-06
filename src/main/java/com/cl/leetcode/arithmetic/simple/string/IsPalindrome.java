package com.cl.leetcode.arithmetic.simple.string;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(" a "));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1)
            return true;
        String regex = "^[a-z0-9A-Z]+$";
        int left = 0;
        int right = s.length();
        s = s.toLowerCase();
        while (left < right) {
            String leftword = s.substring(left, left + 1);
            if (!leftword.matches(regex)) {
                left++;
                continue;
            }
            String rightword = s.substring(right - 1, right);
            if (!rightword.matches(regex)) {
                right--;
                continue;
            }
            if (rightword.equals(leftword)) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }
}
