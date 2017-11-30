package com.cl.dataStructures.hash;

/**
 * Created by cl on 2017/9/21.
 * 线性探测哈希表
 *
 * 扩张数组的策略：创建一个更大的数组，然后复制数据
 *
 */
public class Hash {
    private DataItem[] hashArray;
    int arraySize;
    DataItem nonItem;

    public Hash(int arraySize) {
        this.arraySize = arraySize;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);//定义一个空
    }

    void display() {
        System.out.println("table : ");
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null)
                System.out.print(hashArray[i].getKey()+ " ");
        }
        System.out.println();
    }

    int hashFunc(int key) {//hash函数
        return key % arraySize;
    }

    void insert(DataItem dataItem) {
        int key = dataItem.getKey();
        int hashVal = hashFunc(key);
        //判断是否有值
        while (hashArray[hashVal] != null && hashArray[hashVal].getKey() != -1) {
            //hash规则
            ++hashVal;
            hashVal %= arraySize;
        }
        hashArray[hashVal] = dataItem;
    }

    DataItem delete(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key) {
                //将对应空定义为空
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    DataItem find(int key) {
        int hashVal = hashFunc(key);
        while (hashArray[hashVal] != null) {
            if (hashArray[hashVal].getKey() == key)
                return hashArray[hashVal];
            ++hashVal;
            hashVal %= arraySize;
        }
        return null;
    }

    public static void main(String[] args) {
        Hash hash = new Hash(20);
        for (int i = 0; i < 10; i++) {
            hash.insert(new DataItem((int) (Math.random() * 50)));
        }
        hash.display();
    }
}

class DataItem {
    private int iDdata;

    public DataItem(int iDdata) {
        this.iDdata = iDdata;
    }

    public int getKey() {
        return iDdata;
    }
}
