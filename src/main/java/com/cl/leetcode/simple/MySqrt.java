package com.cl.leetcode.simple;

public class MySqrt {
    public static void main(String[] args) {
//        System.out.println(mySqrt(0));
//        System.out.println(mySqrt(1));
//        System.out.println(mySqrt(2));
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
        System.out.println(mySqrt(Integer.MAX_VALUE - 1));
    }

    public static int mySqrt(int x) {
        if (x == 0)
            return 0;
        int base = 1;
        int max = 32768;
        while (base <= x) {
            if (base > max) {
                base -= base / 4;
                continue;
            }
            if (base == max) {
                base -= 1;
                continue;
            }
            int multi = base * base;
            int multi1 = (base + 1) * (base + 1);
            if (multi1 == 0) {
                return base;
            }
            if (multi == x) {
                return base;
            }
            if (multi1 == x) {
                return base + 1;
            }
            if (multi < x) {
                if (x < multi1)
                    return base;
                base += base;
                continue;
            }
            if (multi > x) {
                base -= base / 4;
            }
        }
        return base;
    }
}
