package com.cl.dataStructures.advancedsord;

/**
 * Created by cl on 2017/9/18.
 * 划分
 *
 * 划分算法由两个指针开始工作，两个指针分别指向数组的两头，通过比较实现指针移动
 */
public class Partition {
    private long[] theArray;
    private int nElems;

    public Partition(int max) {
        theArray = new long[max];
        this.nElems = 0;
    }

    void insert(long value) {
        theArray[nElems++] = value;
    }

    void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(theArray[i] + " ");
        }
        System.out.println();
    }

    int getnSize() {
        return nElems;
    }

    void swap(int d1, int d2) {
        long temp;
        temp = theArray[d1];
        theArray[d1] = theArray[d2];
        theArray[d2] = temp;
    }

    int partitionIt(int left, int right, long pviot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pviot)
                ;
            while (right > leftPtr && theArray[--rightPtr] > pviot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    public static void main(String[] args) {
        int size = 16;
        Partition partition = new Partition(size);
        for (int i = 0; i < size; i++) {
            partition.insert((long) (Math.random() * 199));
        }

        partition.display();
        long pivot = 99;

        int part = partition.partitionIt(0,partition.getnSize()-1, pivot);
        System.out.println(part);
        partition.display();
    }


}
