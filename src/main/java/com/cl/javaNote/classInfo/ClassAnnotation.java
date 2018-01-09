package com.cl.javaNote.classInfo;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.Annotation;

/**
 * Created by cl on 2017/12/1.
 * 获取类注解
 */
public class ClassAnnotation {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        Annotation[] annotations = basicClass.getAnnotations();
        System.out.println(annotations);

    }
}
