//: net/mindview/util/CollectionData.java
// A Collection filled with data using a generator object.
package com.cl.javaNote.util;

import java.util.ArrayList;

/**
 * 应用适配器模式  将Generator转换成CollectionData
 *
 * 在Generator在容器中放置所需数量的对象，然后产生的容器可以传递给任何Collection的构造器
 *
 * @param <T>
 */
public class CollectionData<T> extends ArrayList<T> {
    public CollectionData(Generator<T> gen, int quantity) {
        for (int i = 0; i < quantity; i++)
            add(gen.next());
    }

    // A generic convenience method:
    public static <T> CollectionData<T>
    list(Generator<T> gen, int quantity) {
        return new CollectionData<T>(gen, quantity);
    }
} ///:~
