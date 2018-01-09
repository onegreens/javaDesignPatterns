package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 创建一个类，它持有一个String,并且又一个显示这个String的toString()方法。
 * 将你的新类的若干个对象添加到一个Sequence对象中，然后显示它们
 *
 */
public class Practice2 {
    String name;

    public Practice2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Practice2{" +
                "name='" + name + '\'' +
                '}';
    }
}
