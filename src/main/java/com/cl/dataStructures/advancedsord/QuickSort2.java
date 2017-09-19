package com.cl.dataStructures.advancedsord;

/**
 * Created by cl on 2017/9/18.
 * 快速排序
 * 独立的medianOf方法对左端、中间、以及右端数据进行排序
 */
public class QuickSort2 {
    private long[] thisArray;
    private int nElems;

    public QuickSort2(int max) {
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

    /**
     * 三项数据排序
     * @param left
     * @param right
     * @return
     */
    long medianOf(int left, int right) {
        int center = (left + right) / 2;
        if (thisArray[left] > thisArray[center])
            swap(left, center);
        if (thisArray[left] > thisArray[right])
            swap(left, right);
        if (thisArray[center] > thisArray[right])
            swap(center, right);

        swap(center, right - 1);
        return thisArray[right - 1];

    }

    void manualSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 1)
            return;
        if (size == 2) {
            if (thisArray[left] > thisArray[right])
                swap(left, right);
            return;
        } else {
            if (thisArray[left] > thisArray[right - 1])
                swap(left, right - 1);
            if (thisArray[left] > thisArray[right])
                swap(left, right);
            if (thisArray[right - 1] > thisArray[right])
                swap(right - 1, right);
        }
    }

    void swap(int d1, int d2) {
        long temp;
        temp = thisArray[d1];
        thisArray[d1] = thisArray[d2];
        thisArray[d2] = temp;
    }

    int partitionIt(int left, int right, long pviot) {
        int leftPtr = left;
        int rightPtr = right -1;
        while (true) {
            while (thisArray[++leftPtr] < pviot)
                ;
            while (thisArray[--rightPtr] > pviot)
                ;

            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr,right-1);
        return leftPtr;
    }

    void recQuickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right);
        else {
            long pivot = medianOf(left, right);
            int partition = partitionIt(left, right, pivot);
            recQuickSort(left, partition - 1);
            recQuickSort(partition + 1, right);
        }
    }

    void sort() {
        recQuickSort(0, nElems - 1);
    }

    public static void main(String[] args) {
        int size = 16;
        QuickSort2 sort = new QuickSort2(size);
        for (int i = 0; i < size; i++) {
            sort.insert((long) (Math.random() * 199));
        }
        sort.display();
        sort.sort();
        sort.display();

    }

}
