package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2017/12/29.
 * 修改Practice5
 * 让两个重载方法各自接收连个类型的不同参数名
 * 但二者顺序相反，验证其是否工作
 */
public class Practice6 {
    public static void main(String[] args) {
        Dog6 dog = new Dog6();
        dog.bark(1, "barking");
        dog.bark("barking", 1);

    }
}
//just 1 bark it is barking
//        it is barking just 1 bark

class Dog6 {
    void bark(int i, String bark) {
        System.out.println("just " + i + " bark" + " it is " + bark);
    }

    void bark(String bark, int i) {
        System.out.println("it is " + bark + " just " + i + " bark");
    }
}
