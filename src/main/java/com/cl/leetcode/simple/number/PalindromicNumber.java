package com.cl.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class PalindromicNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(101));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        List<Integer> list = new ArrayList<Integer>();
        while (x >= 10) {
            list.add(x % 10);
            x = x / 10;
        }
        list.add(x);
        int len = list.size();
        if(len == 1){
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            int j = len - i - 1;
            if (j <= i)
                break;
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;
    }
}
