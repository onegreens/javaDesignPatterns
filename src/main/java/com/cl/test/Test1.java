package com.cl.test;

/**
 * Created by cl on 2017/10/9.
 */
public class Test1 {
    public Test1() {
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test1{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");

        operate(a, b); // 把 a, b 的指向两个string buffer 的内存地址的值传进去
        System.out.println(a + "," + b);
    }

    static void operate(StringBuffer a, StringBuffer b) {
        b = a;
        a.append(b); // a 现在指向传入的 StringBuffer("A") 实例的内存地址
        // 这个引用的实例被改动，变成了 AB
        ; // 但是这里b 原来引用的 StringBuffer("B")实例的内存地址被改了，不再指向传入的这个内存
        // 地址，而是指向了 a 所引用的内存地址。
        // 因此这个方法执行完以后，传入的b 所引用的实例没有改变
    }
}
