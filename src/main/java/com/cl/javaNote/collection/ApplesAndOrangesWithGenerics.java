package com.cl.javaNote.collection;

import java.util.ArrayList;

/**
 * Created by cl on 2017/9/8.
 * 相对于 ApplesAndOrangesWithoutGenerics
 * 该实例确定集合类型
 */
public class ApplesAndOrangesWithGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<Apple>();
        for(int i = 0; i < 3; i++)
            apples.add(new Apple());
        // Compile-time error:
        // apples.add(new Orange());
        for(int i = 0; i < apples.size(); i++)
            System.out.println(apples.get(i).id());
        // Using foreach:
        for(Apple c : apples)
            System.out.println(c.id());
    }
}
