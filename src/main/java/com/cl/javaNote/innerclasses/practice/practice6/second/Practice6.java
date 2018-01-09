package com.cl.javaNote.innerclasses.practice.practice6.second;

import com.cl.javaNote.innerclasses.practice.practice6.first.Method;

/**
 * Created by cl on 2017/12/26.
 */
public class Practice6 {
    protected class Inner6 implements Method{
        public void say() {
            System.out.println("just say");
        }
    }
}
