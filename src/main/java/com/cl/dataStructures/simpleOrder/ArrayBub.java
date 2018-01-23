package com.cl.dataStructures.simpleOrder;

/**
 * Created by cl on 2017/9/11.
 * 冒泡排序
 */
public class ArrayBub {
    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        this.a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void insertByselectionSort(long value) {
        a[nElems] = value;
        nElems++;
        selectionSort();
    }

    public void insertBybubbleSort(long value) {
        a[nElems] = value;
        nElems++;
        bubbleSort();
    }

    public void insertByinsertSort(long value) {
        a[nElems] = value;
        nElems++;
        insertSort();
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }

    /**
     * 冒泡排序
     * 将比较值推到预定位置
     */
    public void bubbleSort() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] > a[in + 1])
                    swap(in, in + 1);
            }
        }
    }

    /**
     * 冒泡排序 - 逆序
     */
    public void bubbleSortUn() {
        int out, in;
        for (out = nElems - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in] < a[in + 1])
                    swap(in, in + 1);
            }
        }
    }

    /**
     * 选择排序
     * 将比较值挑选出来，放到预定位置
     */
    public void selectionSort() {
        int in, out, min;
        for (out = 0; out < nElems; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min])
                    min = in;
            }
            swap(out, min);
        }
    }

    /**
     * 选择排序
     */
    public void selectionSortUn() {
        int in, out, min;
        for (out = 0; out < nElems; out++) {
            min = out;
            for (in = out + 1; in < nElems; in++) {
                if (a[in] > a[min])
                    min = in;
            }
            swap(out, min);
        }
    }

    /**
     * 插入排序
     */
    public void insertSort() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] >= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    /**
     * 插入排序 - 逆序
     */
    public void insertSortUn() {
        int in, out;
        for (out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] <= temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }


    public void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

    public long median() {
        int median = nElems / 2;
        return a[median];
    }

    /**
     * 无重复
     */
    public void noDup() {
        for (int i = 0; i < nElems; i++) {
            long out = a[i];
            for (int j = i + 1; j < nElems; j++) {
                if (out == a[j]) {
                    a[j] = a[nElems - 1];
                    nElems--;
                    j--;
                }
            }
        }
    }

    /**
     * 无重复
     */
    public void noDupNoInsert() {
        for (int i = 0; i < nElems; i++) {
            long out = a[i];
            for (int j = i + 1; j < nElems; j++) {
                if (out == a[j]) {
                    for (int k = j; k < nElems; k++) {
                        a[i] = a[i + 1];
                    }
                    nElems--;
                }
            }
        }

    }

    /**
     * 去重复测试
     */
    public static void testNoDup() {
        int maxSize = 100000;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr.insert((long) (Math.random() * (maxSize / 10 - 1)));
        }
        long begin, end;

        begin = System.currentTimeMillis();
        arr.noDup();
        end = System.currentTimeMillis();
        System.out.println("noDup: " + (end - begin));

        ArrayBub arr1;
        arr1 = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr1.insert((long) (Math.random() * (maxSize / 10 - 1)));
        }
        begin = System.currentTimeMillis();
        arr1.noDupNoInsert();
        end = System.currentTimeMillis();
        System.out.println("noDupNoInsert: " + (end - begin));


        arr.noDupNoInsert();
    }

    public static void testmedian() {
        int maxSize = 1001;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr.insertBybubbleSort((long) (Math.random() * (maxSize - 1)));
        }
        long median = arr.median();
        System.out.println(median);
        int max = 0;
        int min = 0;
        int eq = 0;
        for (int i = 0; i < arr.nElems; i++) {
            if (median > arr.a[i]) {
                max++;
            } else if (median < arr.a[i]) {
                min++;
            } else {
                eq++;
            }
        }
        System.out.println(max);
        System.out.println(min);
        System.out.println(eq);
    }

    public static void main4(String[] args) {
//        ArrayBub.testmedian();
        ArrayBub.testNoDup();
    }


    public static void main(String[] args) {
        /*
        插入排序效率对比
         */
        int maxSize = 1000;
        long begin, end;

        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        begin = System.currentTimeMillis();
        for (int i = 0; i < maxSize; i++) {
            arr.insertBybubbleSort((long) (Math.random() * (maxSize - 1)));
        }
        end = System.currentTimeMillis();
        System.out.println("insertBybubbleSort: " + (end - begin));
        arr.display();

        ArrayBub arr1;
        arr1 = new ArrayBub(maxSize);
        begin = System.currentTimeMillis();
        for (int i = 0; i < maxSize; i++) {
            arr1.insertByinsertSort((long) (Math.random() * (maxSize - 1)));
        }
        end = System.currentTimeMillis();
        System.out.println("insertByinsertSort: " + (end - begin));
        arr1.display();

        ArrayBub arr2;
        arr2 = new ArrayBub(maxSize);
        begin = System.currentTimeMillis();
        for (int i = 0; i < maxSize; i++) {
            arr2.insertByselectionSort((long) (Math.random() * (maxSize - 1)));
        }
        end = System.currentTimeMillis();
        System.out.println("insertByselectionSort: " + (end - begin));
        arr2.display();
    }

    public static void main3(String[] args) {
        /*
        逆序效率对比
         */
        int maxSize = 10000;
        long begin, end;

        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr.insert((long) (Math.random() * (maxSize - 1)));
        }
        begin = System.currentTimeMillis();
        arr.bubbleSortUn();
        end = System.currentTimeMillis();
        System.out.println("bubbleSortUn: " + (end - begin));
        arr.display();

        ArrayBub arr1;
        arr1 = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr1.insert((long) (Math.random() * (maxSize - 1)));
        }
        begin = System.currentTimeMillis();
        arr1.insertSortUn();
        end = System.currentTimeMillis();
        System.out.println("insertSortUn: " + (end - begin));
        arr1.display();

        ArrayBub arr2;
        arr2 = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr2.insert((long) (Math.random() * (maxSize - 1)));
        }
        begin = System.currentTimeMillis();
        arr2.selectionSortUn();
        end = System.currentTimeMillis();
        System.out.println("selectionSortUn: " + (end - begin));
        arr2.display();

    }

    public static void main2(String[] args) {
        /*
        顺序效率对比
         */
        int maxSize = 10000;
        long begin, end;

        ArrayBub arr;
        arr = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr.insert((long) (Math.random() * (maxSize - 1)));
        }
        begin = System.currentTimeMillis();
        arr.bubbleSort();
        end = System.currentTimeMillis();
        System.out.println("bubbleSort: " + (end - begin));

        ArrayBub arr1;
        arr1 = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr1.insert((long) (Math.random() * (maxSize - 1)));
        }
        begin = System.currentTimeMillis();
        arr1.insertSort();
        end = System.currentTimeMillis();
        System.out.println("insertSort: " + (end - begin));

        ArrayBub arr2;
        arr2 = new ArrayBub(maxSize);
        for (int i = 0; i < maxSize; i++) {
            arr2.insert((long) (Math.random() * (maxSize - 1)));
        }
        begin = System.currentTimeMillis();
        arr2.selectionSort();
        end = System.currentTimeMillis();
        System.out.println("selectionSort: " + (end - begin));


    }

    public static void main1(String[] args) {
        int maxSize = 100;
        ArrayBub arr;
        arr = new ArrayBub(maxSize);

        arr.insert(77);
        arr.insert(44);
        arr.insert(44);
        arr.insert(22);
        arr.insert(22);
        arr.insert(11);
        arr.insert(00);
        arr.insert(33);
        arr.insert(33);
        arr.display();
        System.out.println(">>>>>>>>>>>>>>>>>>>");
//        arr.bubbleSort();
//        arr.selectionSort();
        arr.insertSort();
        System.out.println(">>>>>>>>>>>>>>>>>>>");

        arr.display();
    }
}
