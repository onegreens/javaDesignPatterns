package com.cl.leetcode.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个只包括 '(',')','{','}','[',']' 的字符串,判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
public class ParenthesesIsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[{[]]]}]}"));
        System.out.println(isValid("(([]){})"));
        /**
         true
         true
         false
         false
         false
         true
         */
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        List<String> left = new ArrayList();
        int index = 0;
        while (index < s.length()) {
            String item = s.substring(index, index + 1);
            switch (item) {
                case "(":
                    left.add(item);
                    break;
                case "{":
                    left.add(item);

                    break;
                case "[":
                    left.add(item);
                    break;
                case ")":
                    if (index == 0) return false;
                    String pre1 = left.get(left.size() - 1);
                    if (pre1.equals("(")) {
                        left.remove(left.size() - 1);
                    } else {
                        return false;
                    }
                    break;
                case "}":
                    if (index == 0) return false;
                    String pre2 = left.get(left.size() - 1);
                    if (pre2.equals("{")) {
                        left.remove(left.size() - 1);
                    } else {
                        return false;
                    }
                    break;
                case "]":
                    if (index == 0) return false;
                    String pre3 = left.get(left.size() - 1);
                    if (pre3.equals("[")) {
                        left.remove(left.size() - 1);
                    } else {
                        return false;
                    }
                    break;

                default:
                    return false;

            }
            index++;
        }
        if (left.size() != 0) {
            return false;
        }
        return true;
    }

    public static boolean isValid1(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        int index = 0;
        while (index < s.length()) {
            String item = s.substring(index, index + 1);
            switch (item) {
                case "(":
                    left++;
                    break;
                case "{":
                    left++;

                    break;
                case "[":
                    left++;

                    break;
                case ")":
                    if (index == 0) return false;
                    right++;
                    String pre1 = s.substring(index - 1, index);
                    if (pre1.equals("(")) {
                        if (s.length() == 2) {
                            s = "";
                            break;
                        }
                        s = s.substring(0, index - 1) + s.substring(index + 1, s.length());
                        index -= 2;

                    } else {
                        return false;
                    }
                    break;
                case "}":
                    if (index == 0) return false;
                    right++;
                    String pre2 = s.substring(index - 1, index);
                    if (pre2.equals("{")) {
                        if (s.length() == 2) {
                            s = "";
                            break;
                        }
                        s = s.substring(0, index - 1) + s.substring(index + 1, s.length());
                        index -= 2;

                    } else {
                        return false;
                    }
                    break;
                case "]":
                    if (index == 0) return false;
                    right++;
                    String pre3 = s.substring(index - 1, index);
                    if (pre3.equals("[")) {
                        if (s.length() == 2) {
                            s = "";
                            break;
                        }
                        s = s.substring(0, index - 1) + s.substring(index + 1, s.length());
                        index -= 2;
                    } else {
                        return false;
                    }
                    break;

                default:
                    return false;

            }
            index++;
        }
        if (left != right) {
            return false;
        }
        return true;
    }
}
