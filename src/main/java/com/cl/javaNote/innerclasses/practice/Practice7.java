package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2017/12/26.
 * 创建一个含有private域和private方法的类，创建一个内部类，它有一个方法可以修改外围类的域，并调用外围类的方法，
 * 在外围类的另一个方法中，创建此内部类的对象，并且调用它的方法，然后说明外围类对象的影响
 */
public class Practice7 {
    public Practice7(String name) {
        this.name = name;
    }

    private String name;

    private void say() {
        System.out.println("Practice7:just say " + name);
    }

    void sayName(String name){
        new Inner7().change(name);
    }

    class Inner7 {
        void change(String name) {
            Practice7.this.name = name;//缺少任意元素则不可使用
            Practice7.this.say();//也可以直接 say();
        }
    }

    public static void main(String[] args) {
        new Practice7("张桑").sayName("李四");
    }
}
