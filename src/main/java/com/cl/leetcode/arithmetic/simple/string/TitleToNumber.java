package com.cl.leetcode.arithmetic.simple;

import org.apache.poi.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 示例 1:
 * <p>
 * 输入: 'A'
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: 'AB'
 * 输出: 28
 * 示例 3:
 * <p>
 * 输入: 'ZY'
 * 输出: 701
 */
public class TitleToNumber {
    public static void main(String[] args) {
//        System.out.println(titleToNumber("A"));
//        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        int num = 0;
        String[] strings = {"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        List<String> list = Arrays.asList(strings);
        int len = s.length();
        if (len > 0) {
            String[] strings1 = s.split("");
            for (int i = 0; i < len; i++) {
                num += list.indexOf(strings1[i]) * Math.pow(26, len - i - 1);
            }

        }
        return num;
    }
}
