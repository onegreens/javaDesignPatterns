package com.cl.leetcode.simple.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
public class Generate {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        int index = 0;
        List<Integer> pre = new ArrayList<>();
        while (index < numRows) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if (pre.size() >= 2) {
                for (int i = 1; i < pre.size(); i++) {
                    list.add(pre.get(i) + pre.get(i - 1));
                }
                list.add(1);

            } else if (pre.size() == 1) {
                list.add(1);
            }
            result.add(list);
            index++;
            pre = list;
        }
        return result;
    }
}
