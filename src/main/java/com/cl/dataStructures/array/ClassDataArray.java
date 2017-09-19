package com.cl.dataStructures.array;

/**
 * Created by cl on 2017/9/11.
 */
public class ClassDataArray {
    private Person[] a;
    private int nElems;

    public ClassDataArray() {
    }

    public ClassDataArray(int size) {
        this.a = new Person[size];
        nElems = 0;
    }

    public Person find(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName))
                break;
        }
        if (j == nElems)
            return null;
        else
            return a[j];
    }

    public void insert(String lastName, String firstName, int age) {
        a[nElems] = new Person(lastName,firstName,age);
        nElems++;
    }

    public boolean delete(String searchName) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (a[j].getLastName().equals(searchName))
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
            System.out.println(a[i].toString());
        }
    }

    public static void main(String[] args) {
        int maxize = 100;
        ClassDataArray arr;
        arr = new ClassDataArray(maxize);
        String searchKey = "a";

        arr.insert("a","q",11);
        arr.insert("s","w",12);
        arr.insert("d","e",13);
        arr.insert("f","r",14);
        arr.insert("g","t",15);
        arr.insert("h","y",16);
        arr.insert("j","u",18);
        arr.insert("k","i",19);
        arr.display();

        Person person = arr.find(searchKey);
        if (person == null)
            System.out.println("can't find " + searchKey);
        else
            System.out.println("find " + person);
        arr.delete("a");
        arr.delete("d");

        arr.display();

    }
}
