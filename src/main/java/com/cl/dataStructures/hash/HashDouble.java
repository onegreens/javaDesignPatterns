package com.cl.dataStructures.hash;

/**
 * Created by cl on 2017/9/21.
 * 再哈希化
 */
public class HashDouble {
    private DataItem[] hashArray;
    int arraySize;
    DataItem nonItem;

    public HashDouble(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);//定义一个空
    }

    void display() {
        System.out.println("table : ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null)
                System.out.print(hashArray[i].getKey() + " ");
        }
        System.out.println();
    }

    int hashFunc1(int key) {//hash函数
        return key % arraySize;
    }

    int hashFunc2(int key) {//hash函数
        return 5 - key % 5;
    }

    void insert(DataItem dataItem) {
        int key = dataItem.getKey();
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        //判断是否有值
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            //hash规则
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = dataItem;
    }

    DataItem delete(int key) {
        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                //将对应空定义为空
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    DataItem find(int key) {

        int hashVal = hashFunc1(key);
        int stepSize = hashFunc2(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            hashVal += stepSize;
            hashVal %= arraySize;
        }
        return null;
    }

    public static void main(String[] args) {
        HashDouble hash = new HashDouble(20);
        for (int i = 0; i < 10; i++) {
            hash.insert(new DataItem((int) (Math.random() * 50)));
        }
        hash.display();
    }


}
