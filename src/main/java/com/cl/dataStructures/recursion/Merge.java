package com.cl.dataStructures.recursion;

/**
 * Created by cl on 2017/9/14.
 * 归并两个有序数组
 */
public class Merge {
    public static void main(String[] args) {
        int[] a = {23,34,45,56};
        int[] b = {22,33,44,55,66,77};
        int[] c = new int[10];
        merge(a,4,b,6,c);
        for (int i = 0; i < 10; i++) {
            System.out.println(c[i]);
        }
    }

    static void merge(int[] arrayA, int sizeA,
                      int[] arrayB, int sizeB,
                      int[] arrayC) {
        int aDex = 0, bDex = 0, cDex = 0;
        while (aDex < sizeA && bDex < sizeB)
            if (arrayA[aDex] < arrayB[bDex])
                arrayC[cDex++] = arrayA[aDex++];
            else
                arrayC[cDex++] = arrayB[bDex++];

        while (aDex < sizeA)
            arrayC[cDex++] = arrayA[aDex++];

        while (bDex < sizeB)
            arrayC[cDex++] = arrayB[bDex++];

    }


}
