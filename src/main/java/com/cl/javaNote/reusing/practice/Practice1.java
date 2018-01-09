package com.cl.javaNote.reusing.practice;

/**
 * Created by cl on 2018/1/3.
 * 创建一个简单的类
 * 在第二个类中，将一个引用定义为第一个类的对象
 * 运用惰性初始化来实例化这个对象
 */
public class Practice1 {
    Simple1 simple1;

    @Override
    public String toString() {
        if (simple1 == null)
            simple1 = new Simple1();
        return "Practice1{" +
                "simple1=" + simple1 +
                '}';
    }
}
class Simple1{

}
