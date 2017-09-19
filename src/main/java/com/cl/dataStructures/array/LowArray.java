package com.cl.dataStructures.array;

/**
 * Created by cl on 2017/9/11.
 将程序划分为类
 在Array.class基础上改进
 */
public class LowArray {
    private long[] a;

    public LowArray() {
    }

    public LowArray(int size) {
        this.a = new long[size];
    }

    public void setElem(int index, long value) {
        a[index] = value;
    }

    public long getIndex(int index) {
        return a[index];
    }

    public static void main(String[] args) {
        LowArray arr;
        arr = new LowArray(100);
        int nElems = 0;
        int j;
        long searchKey;

        arr.setElem(0, 77);
        arr.setElem(1, 99);
        arr.setElem(2, 44);
        arr.setElem(3, 55);
        arr.setElem(4, 22);
        arr.setElem(5, 88);
        arr.setElem(6, 11);
        arr.setElem(7, 00);
        arr.setElem(8, 66);
        arr.setElem(9, 33);
        nElems = 10;

        for (int i = 0; i < nElems; i++) {
            System.out.print(arr.getIndex(i) + " ");
        }
        System.out.println(" ");

        searchKey = 66;
        for (j = 0; j < nElems; j++) {
            if (arr.getIndex(j) == searchKey)
                break;
        }
        if (j == nElems)
            System.out.println("can't find " + searchKey);
        else
            System.out.println("find " + searchKey);

        searchKey = 55;
        for (j = 0; j < nElems; j++) {
            if (arr.getIndex(j) == searchKey)
                break;
        }
        for (int i = j; i < nElems; i++) {
            arr.setElem(i, arr.getIndex(j));
        }
        nElems--;

        for (int i = 0; i < nElems; i++) {
            System.out.print(arr.getIndex(i) + " ");
        }
    }
}
