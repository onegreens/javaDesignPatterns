package com.cl.dataStructures.array;

/**
 * Created by cl on 2017/9/11.
 */
public class HighArray {
    private long[] a;
    private int nElems;

    public HighArray() {
    }

    public HighArray(int size) {
        this.a = new long[size];
        nElems = 0;
    }

    public boolean find(long searchKey) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == searchKey)
                break;
        }
        if (j == nElems)
            return false;
        else
            return true;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j] == value)
                break;
        }
        if (j == nElems)
            return false;
        else {
            for (int i = j; i < nElems; i++) {
                a[i] = a[i + 1];
            }
            nElems--;
            return true;
        }

    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    /**
     * 获取最大值
     * @return
     */
    public long getMax() {
        if (a[0] == 0)
            return -1;
        long max = 0;
        for (int i = 0; i < nElems; i++) {
            if (max < a[i])
                max = a[i];
        }
        return max;
    }

    public void removeMax() {
        long max = getMax();
        if (max != -1)
            delete(max);
    }

    /**
     * 去重复
     */
    public void noDup(){
        for (int i = 0; i < nElems; i++) {
            long value = a[i];
            for (int j = i+1; j < nElems; j++) {
                if (value == a[j]){
                    for (int s = j; s < nElems; s++) {
                        a[s] = a[s + 1];
                    }
                    nElems--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxize = 100;
        HighArray arr;
        arr = new HighArray(maxize);

        arr.insert(77);
        arr.insert(00);
        arr.insert(44);
        arr.insert(44);
        arr.insert(22);
        arr.insert(22);
        arr.insert(11);
        arr.insert(00);
        arr.insert(33);
        arr.insert(33);
        arr.noDup();
        arr.display();
    }

    public static void main1(String[] args) {
        int maxize = 100;
        HighArray arr;
        arr = new HighArray(maxize);
        long searchKey = 66;

        arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        if (arr.find(searchKey))
            System.out.println("can't find " + searchKey);
        else
            System.out.println("find " + searchKey);

        arr.delete(00);
        arr.delete(99);
        arr.delete(55);

        arr.display();

        System.out.println(arr.getMax());
        arr.removeMax();
        System.out.println(arr.getMax());

        //实现倒序
        HighArray copy;
        copy = new HighArray(maxize);
        while (arr.getMax() != -1) {
            copy.insert(arr.getMax());
            arr.removeMax();
        }
        copy.display();
    }
}
