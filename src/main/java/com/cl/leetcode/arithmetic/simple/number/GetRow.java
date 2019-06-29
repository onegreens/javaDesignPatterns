package com.cl.leetcode.arithmetic.simple.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {

        int index = 0;
        List<Integer> pre = new ArrayList<>();
        while (index < rowIndex + 1) {
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
            index++;
            pre = list;
        }
        return pre;
    }
}
