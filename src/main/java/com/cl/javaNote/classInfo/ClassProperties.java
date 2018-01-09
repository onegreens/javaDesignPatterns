package com.cl.javaNote.classInfo;

import java.lang.reflect.Field;

/**
 * Created by cl on 2017/12/15.
 */
public class ClassProperties {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        Field[] fields = basicClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }

    public void setValue() throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        Field field = null;
        String name = null;
        String value = null;
        try {
            field = basicClass.getDeclaredField(name);
            field.setAccessible(true); // 抑制Java对修饰符的检查
            field.set(basicClass, value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}

