package com.cl.leetcode.arithmetic.simple.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * <p>
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */
public class MaxPoints {
    //todo
    public int maxPoints(int[][] points) {
        Map<Double, Integer> map = new HashMap<>();
        int max = 0;
        int no = 0;
        for (int i = 1; i < points.length; i++) {
            int[] other = points[i];
            for (int j = 0; j < i; j++) {
                int[] base = points[j];
                if ((other[0] - base[0]) == 0) {
                    no++;
                } else {
                    double k = (other[1] - base[1]) / (other[0] - base[0]);
                    if (map.get(k) == null) {
                        map.put(k, 1);
                        if (max < 1) max = 1;
                    } else {
                        int val = map.get(k) + 1;
                        map.put(k, val);
                        if (max < val) max = val;

                    }
                }

            }
        }
        return max > no ? max : no;
    }
}
