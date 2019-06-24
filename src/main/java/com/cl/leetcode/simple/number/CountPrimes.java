package com.cl.leetcode.simple.number;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.sqrt;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(0));
        System.out.println(countPrimes(1));
        System.out.println(countPrimes(2));
        System.out.println(countPrimes(3));
        System.out.println(countPrimes(10));
    }


    public static int countPrimes(int n) {
        int res = 1;//从3开始计算，所以初始为1
        if (n < 3) return 0;
        else {
            for (int i = 3; i < n; i++) {
                if (i % 2 == 0)
                    continue;
                boolean flag = true;//false表示不是素数
                int sqrt = (int) sqrt(i);

                for (int j = 3; j <= sqrt; j += 2) {
                    if (i % j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        return res;
    }

    public static int countPrimes1(int n) {//超时
        if (n < 3) {
            return 0;
        }
        int num = 1;
        int[] primes = new int[n / 2];
        primes[0] = 2;
        int m = 3;
        int multi = 0;
        while (m < n) {
            boolean isPrimes = true;
            int sqrt = (int) Math.sqrt(m);
            for (int i = 0; i < num; i++) {
                int index = primes[i];
                if (index > sqrt) {
                    isPrimes = true;
                    break;
                }
                if (m % index == 0) {
                    isPrimes = false;
                    break;
                }
            }
            if (isPrimes) {
                primes[num] = m;
                num++;
            }
            m += 2;
            multi++;
            if (multi % 3 == 0) {
                m += 2;
                multi++;
            }
        }
        return num;
    }
}
