package com.cl.leetcode.arithmetic.simple.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 * <p>
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 * <p>
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 * 示例 2：
 * <p>
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 */
public class PowerfulIntegers {
    public static void main(String[] args) {
        System.out.println(powerfulIntegers(3, 5, 15));
    }

    public static List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        if (bound > 1) {
            int powi = 1;
            while (powi < bound) {
                int powj = 1;
                while (powj < bound) {
                    int sum = powi + powj;
                    if (sum <= bound) {
                        if (list.indexOf(sum) == -1)
                            list.add(sum);
                    } else {
                        break;
                    }
                    if (y == 1)
                        break;
                    powj *= y;
                }
                if (x == 1)
                    break;
                powi *= x;
            }
        }
        return list;
    }
}
