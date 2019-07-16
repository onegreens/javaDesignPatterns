package com.cl.leetcode.arithmetic.simple.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * <p>
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * <p>
 * 注意：
 * 0 ≤ x, y < 231.
 * <p>
 * 示例:
 * <p>
 * 输入: x = 1, y = 4
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * ↑   ↑
 * <p>
 * 上面的箭头指出了对应二进制位不同的位置。
 */
public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    public static int hammingDistance(int x, int y) {
        List<Integer> xs = getNumber(x);
        List<Integer> ys = getNumber(y);
        int diff = 0;
        int size = xs.size() - ys.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                ys.add(0);
            }
        }
        if (size < 0) {
            for (int i = 0; i < -size; i++) {
                xs.add(0);
            }
        }
        for (int i = 0; i < xs.size(); i++) {
            if (xs.get(i) != ys.get(i)) diff++;
        }
        return diff;
    }

    public static List<Integer> getNumber(int x) {
        List<Integer> list = new ArrayList<>();
        while (x >= 2) {
            int d = x % 2;
            list.add(d);
            x = x / 2;
        }
        list.add(x);
        return list;
    }
}
