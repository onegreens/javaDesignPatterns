package com.cl.dataStructures.array;

/**
 * Created by cl on 2017/9/11.
 */
public class Array {
    public static void main(String[] args) {
        long[] arr;
        arr = new long[100];
        int nElems = 0;
        int j;
        long searchKey;

        arr[0] = 77;
        arr[1] = 99;
        arr[2] = 44;
        arr[3] = 55;
        arr[4] = 22;
        arr[5] = 88;
        arr[6] = 11;
        arr[7] = 00;
        arr[8] = 66;
        arr[9] = 33;
        nElems = 10;

        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");

        searchKey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey)
                break;
        }
        if (j == nElems)
            System.out.println("can't find " + searchKey);
        else
            System.out.println("find " + searchKey);

        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr[j] == searchKey)
                break;
        }
        for (int i = j; i < nElems; i++) {
            arr[i] = arr[i + 1];
        }
        nElems--;

        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + " ");
        }

    }


}
