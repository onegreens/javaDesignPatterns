package com.cl.pattern.iterator.iter;

/**
 * Created by cl on 2017/7/22.
 * 迭代器基础接口
 */
public interface Iterator {
    /**
     * 是否有下一个
     * @return
     */
    boolean hasNext();

    /**
     * 下一个元素
     * @return
     */
    Object next();
}
