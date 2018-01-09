package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2018/1/5.
 * 创建一个包含嵌套类的接口
 * 该嵌套类中有一个static方法
 * 他将调用接口中的方法并显示接口
 * 实现这个接口
 * 并将这个实现的一个实例传递给这个方法
 */
public class Practice21 {

}
interface Inter21{
    void say();
    static class InterP21{
        public static void say(){
            new Inter21() {
                public void say() {
                    System.out.println("test");
                }
            }.say();
        }
    }
}
