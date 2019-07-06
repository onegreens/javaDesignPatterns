package com.cl.leetcode.arithmetic.simple.number;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例: 
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 1) {
            if (n == 0)
                return false;
            int sum = 0;
            while (n > 9) {
                int m = n % 10;
                n = n / 10;
                sum += m * m;
            }
            sum += n * n;
            if (sum == 1) {
                return true;
            }
            n = sum;
            if (list.indexOf(n) == -1) {
                list.add(n);
            } else {
                return false;
            }
        }
        return true;
    }
}
