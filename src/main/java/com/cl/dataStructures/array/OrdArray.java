package com.cl.dataStructures.array;

/**
 * Created by cl on 2017/9/11.
 * 二分查找
 * 构建有序数组
 */
public class OrdArray {
    private long[] a;
    private int nElems;

    public OrdArray() {
    }

    public OrdArray(int size) {
        this.a = new long[size];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound >= upperBound)
                return nElems;
            else {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    /**
     * 通过递归改造二分查找
     * @param searchKey
     * @return
     */
    public int findByDIGUI(long searchKey) {
        return find(searchKey, 0, nElems - 1);
    }

    public int find(long searchKey, int lowerBound, int upperBound) {
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;
            else if (lowerBound >= upperBound)
                return nElems;
            else {
                if (a[curIn] < searchKey)
                    return find(searchKey, curIn + 1, upperBound);
                else
                    return find(searchKey, lowerBound, curIn - 1);
            }
        }
    }


    public int findOrder(long value) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (lowerBound > upperBound)
                return nElems;
            if (a[curIn] == value)
                return curIn;
            if (a[curIn] < value) {
                lowerBound = curIn + 1;
                if (lowerBound > upperBound)
                    return lowerBound;
            } else {
                upperBound = curIn - 1;
                if (lowerBound > upperBound)
                    return curIn;
            }

        }
    }

    public OrdArray merge(OrdArray o1, OrdArray o2) {
        OrdArray o;
        if (o1.size() > o2.size()) {
            o = o1;
            o.merge(o2);
        } else {
            o = o2;
            o.merge(o1);
        }
        return o;
    }

    public void merge(OrdArray ordArray) {
        for (int i = 0; i < ordArray.size(); i++) {
            this.insert(ordArray.a[i]);
        }
    }

    public void insert(long value) {
        int j = findOrder(value);
        System.out.println(" j :" + j + " value : " + value);
        for (int i = nElems; i > j; i--) {
            a[i] = a[i - 1];
        }
        a[j] = value;
        nElems++;
    }

    public boolean delete(long value) {
        int j = find(value);
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

    public static void main(String[] args) {
        int maxize = 100;
        OrdArray arr;
        arr = new OrdArray(maxize);
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
        arr.insert(66);
        arr.insert(66);
        arr.insert(33);
        arr.display();
        if (arr.find(searchKey) == arr.size())
            System.out.println("can't find " + searchKey);
        else
            System.out.println("find " + searchKey);

        arr.delete(00);
//        arr.delete(99);
        arr.delete(66);

        arr.display();
        System.out.println(arr.findOrder(55));

        OrdArray arr2;
        arr2 = new OrdArray(maxize);

        arr2.insert(77);
        arr2.insert(99);
        arr2.insert(44);
        arr2.insert(55);
        arr2.insert(22);
        arr2.insert(88);
        arr2.insert(11);

        OrdArray arr3 = arr.merge(arr, arr2);
        arr3.display();

    }
}
