package com.cl.test;

import java.util.Random;

/**
 * Created by cl on 2018/1/10.
 */
public class Test9 {
    public static void main(String[] args) {
        Random random = new Random(48);
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
        }
        standardInsert(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    static void bubble(int[] a) {
        int out, in;
        for (out = a.length-1; out >1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in]>a[in+1]){
                    int temp = a[in+1];
                    a[in+1] = a[in];
                    a[in] = temp;
                }
            }

        }
    }

    static void select(int[] a) {
        int in, out, min;
        for (out = 0; out < a.length; out++) {
            min = out;
            for (in = out + 1; in < a.length; in++) {
                if (a[in] < a[min]) {
                    int temp = a[min];
                    a[min] = a[in];
                    a[in] = temp;
                }
            }
        }
    }

    static void standardInsert(int[] a){
        int in,out;
        for (out = 1; out < a.length; out++){
            int temp = a[out];
            in = out;
            while (in >0 && a[in-1]>temp){
                a[in] = a[in-1];
                in --;
            }
            a[in] = temp;
        }
    }

    static void insert(int[] a) {
        int in, out, min;
        for (out = 0; out < a.length; out++) {
            min = out;
            for (in = out + 1; in < a.length; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            int temp = a[min];
            a[min] = a[out];
            a[out] = temp;
        }
    }
}
