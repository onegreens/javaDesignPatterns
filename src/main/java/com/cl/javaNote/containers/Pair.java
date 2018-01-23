package com.cl.javaNote.containers;

/**
 * Created by cl on 2017/10/7.
 */
public class Pair<K,V> {
    public final K key;
    public final V value;
    public Pair(K k, V v) {
        key = k;
        value = v;
    }
}
