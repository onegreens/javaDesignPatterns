package com.work.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cl on 2017/12/15.
 */
public class Test3Po<T,V> {
    List<T> tList;
    V v;

    public List<T> gettList() {
        return tList;
    }

    public void settList(List<T> tList) {
        this.tList = tList;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }

    public static void main(String[] args) {
        Test3Po<TestPo,Test2Po> test3Po = new Test3Po<TestPo, Test2Po>();
        test3Po.settList(new ArrayList<TestPo>());
        test3Po.setV(new Test2Po());
    }
}
