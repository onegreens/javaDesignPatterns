package com.cl.leetcode.arithmetic.simple;

public class Merge {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 7, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + ",");

        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 1;
        int indexm = m;
        int indexn = n;
        while (index <= m + n) {

            int itemn = 0;
            if (indexn >= 1)
                itemn = nums2[indexn - 1];
            else
                break;
            int itemm = 0;
            if (indexm >= 1) {
                itemm = nums1[indexm - 1];

                if (itemm > itemn) {
                    nums1[m + n - index] = itemm;
                    indexm--;
                } else if (itemm < itemn) {
                    nums1[m + n - index] = itemn;
                    indexn--;
                } else {
                    nums1[m + n - index] = itemm;
                    index++;
                    indexm--;
                    nums1[m + n - index] = itemn;
                    indexn--;
                }
            } else {
                nums1[m + n - index] = itemn;
                indexn--;
            }

            index++;
        }
    }
}
