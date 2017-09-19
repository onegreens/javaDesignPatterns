package com.cl.dataStructures.recursion;

/**
 * Created by cl on 2017/9/14.
 * 归并 递归 二分算法 排序
 */
public class MergeSort {
    private long[] array;
    private int nElems;

    public MergeSort(int maxSize) {
        array = new long[maxSize];
        this.nElems = 0;
    }

    void insert(long value) {
        array[nElems] = value;
        nElems++;
    }

    void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(array[i] + "  ");
        }
        System.out.println();
    }

    void mergeSort() {
        long[] workSpace = new long[nElems];
        recMergeSort(workSpace, 0, nElems - 1);
    }

    void recMergeSort(long[] workSpace, int lower, int upper) {
        if (lower == upper)
            return;
        else {
            int mid = (lower + upper) / 2;
            recMergeSort(workSpace, lower, mid);
            recMergeSort(workSpace, mid + 1, upper);
            merge(workSpace, lower, mid + 1, upper);

        }
    }

    void merge(long[] workSpace, int lowPtr, int highPtr, int upper) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upper - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upper)
            if (array[lowPtr] < array[highPtr])
                workSpace[j++] = array[lowPtr++];
            else
                workSpace[j++] = array[highPtr++];

        while (lowPtr <= mid)
            workSpace[j++] = array[lowPtr++];

        while (highPtr <= upper)
            workSpace[j++] = array[highPtr++];
        for (int i = 0; i < n; i++) {
            array[lowerBound + i] = workSpace[i];
        }
    }

    public static void main(String[] args) {
        int size = 100;
        MergeSort mergeSort = new MergeSort(size);
        for (int i = 0; i < 20; i++) {
            mergeSort.insert((long) (Math.random() * 100));
        }
        mergeSort.display();
        mergeSort.mergeSort();
        mergeSort.display();
    }
}
