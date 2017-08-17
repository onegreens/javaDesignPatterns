package com.cl.javaNote.threadNote.newUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by cl on 2017/8/11.
 *
 * 对象池：管理着数量有限的对象，当要使用这些对象时，可以签出它们，当使用完毕时，可以将它们签回
 *
 *
 *
 */
public class Pool<T> {
    private int size;
    private List<T> items = new ArrayList<T>();
    private volatile boolean[] checkedOut;//用于跟踪被签出的对象
    private Semaphore avaliable;

    public Pool(Class<T> classObject, int size) {
        this.size = size;
        checkedOut = new boolean[size];
        avaliable = new Semaphore(size, true);
        for (int i = 0; i < size; i++) {
            try {
                items.add(classObject.newInstance());
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }

    }

    private synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]) {
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    /**
     * 签出对象
     * @return
     * @throws InterruptedException
     */
    public T checkOut() throws InterruptedException {
        avaliable.acquire();
        return  getItem();
    }

    private synchronized boolean releaseItem(T item){
        int index = items.indexOf(item);
        if (index == -1 )
            return false;
        if (checkedOut[index]){
            checkedOut[index] = false;
            return true;
        }
        return false;
    }

    /**
     * 签回对象
     * @param item
     */
    public void checkIn(T item){
        if (releaseItem(item))
            avaliable.release();
    }
}
