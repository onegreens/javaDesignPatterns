package com.cl.interview;

import java.util.Random;

/**
 * Created by cl on 2018/1/13.
 */
public class SimpleOrder {
    static void bubller() {
        int[] a = new int[10];
        Random random = new Random(40);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = random.nextInt(40);
        }
        int out = len;
        while (--out > 0) {
            for (int i = 0; i < out; i++) {
                if (a[i] < a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static void insert() {
        int[] a = new int[10];
        Random random = new Random(40);
        int len = a.length;
        for (int i = 0; i < len; i++) {
            a[i] = random.nextInt(40);
        }
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i = 1; i < len; i++) {
            int temp = a[i];
            int j = i;
            while (j > 0 && a[j-1] > temp) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = temp;
        }
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        insert();
    }
}
