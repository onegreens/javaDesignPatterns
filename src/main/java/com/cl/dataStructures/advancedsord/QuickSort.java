package com.cl.dataStructures.advancedsord;

/**
 * Created by cl on 2017/9/18.
 * 快速排序
 */
public class QuickSort {
    private long[] thisArray;
    private int nElems;

    public QuickSort(int max) {
        thisArray = new long[max];
        this.nElems = 0;
    }

    void insert(long value) {
        thisArray[nElems++] = value;
    }

    void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(thisArray[i] + " ");
        }
        System.out.println();
    }

    void swap(int d1, int d2) {
        long temp;
        temp = thisArray[d1];
        thisArray[d1] = thisArray[d2];
        thisArray[d2] = temp;
    }

    int partitionIt(int left, int right, long pviot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (right > leftPtr && thisArray[--rightPtr] > pviot)
                ;
            while (leftPtr < right && thisArray[++leftPtr] < pviot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    void recQuickSort(int left, int right) {
        if (right - left <= 0)
            return;
        else {
            long pivot = thisArray[right];
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    void sort(){
        recQuickSort(0,nElems-1);
    }

    public static void main(String[] args) {
        int size = 16;
        QuickSort sort = new QuickSort(size);
        for (int i = 0; i < size; i++) {
            sort.insert((long) (Math.random() * 199));
        }
        sort.display();
        sort.sort();
        sort.display();

    }

}
