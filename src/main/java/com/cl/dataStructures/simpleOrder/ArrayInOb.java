package com.cl.dataStructures.simpleOrder;

import com.cl.dataStructures.array.Person;

/**
 * Created by cl on 2017/9/11.
 * 对象排序
 */
public class ArrayInOb {
    private Person[] a;
    private int nElems;

    public ArrayInOb() {
    }

    public ArrayInOb(int size) {
        this.a = new Person[size];
        nElems = 0;
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName, firstName, age);
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.println(a[i].toString());
        }
    }

    public void insertionSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            Person temp = a[out];
            in = out;
            //使用compareTo
            while (in > 0 && a[in - 1].getLastName().compareTo(temp.getLastName()) > 0) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    public static void main(String[] args) {
        int maxize = 100;
        ArrayInOb arr;
        arr = new ArrayInOb(maxize);

        arr.insert("a", "q", 11);
        arr.insert("s", "w", 12);
        arr.insert("d", "e", 13);
        arr.insert("f", "r", 14);
        arr.insert("g", "t", 15);
        arr.insert("h", "y", 16);
        arr.insert("j", "u", 18);
        arr.insert("k", "i", 19);
        arr.display();
        arr.insertionSort();
        arr.display();

    }
}
