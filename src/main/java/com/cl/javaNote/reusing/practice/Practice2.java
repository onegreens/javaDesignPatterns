package com.cl.javaNote.reusing.practice;

import com.cl.javaNote.reusing.Detergent;

import static com.cl.javaNote.util.Print.print;

/**
 * Created by cl on 2018/1/4.
 * 从Detergent中继承产生一个新的类
 * 覆盖scrub()并添加一个名为sterilize()的新方法
 */
public class Practice2 extends Detergent {
    public void scrub() {
        append(" Detergent.scrub()");
    }

    public void sterilize() {
        print(this);
    }

    public static void main(String[] args) {
        new Practice2().sterilize();
    }
}
