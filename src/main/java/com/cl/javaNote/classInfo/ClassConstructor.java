package com.cl.javaNote.classInfo;


import java.lang.reflect.Constructor;

/**
 * 获取类构造器
 *
 */
public class ClassConstructor {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        /**
         * 返回此Class对象对应类的带指定形参的public构造器
         */
        Constructor<BasicClass> constructor;
        constructor = (Constructor<BasicClass>) basicClass.getConstructor();
        System.out.println(constructor);

        constructor = (Constructor<BasicClass>) basicClass.getConstructor(Integer.class);
        System.out.println(constructor);

        /**
         * 返回此Class对象对应类的所有public构造器
         */
        Constructor<BasicClass>[] constructors;
        constructors = (Constructor<BasicClass>[]) basicClass.getConstructors();
        System.out.println(constructors);


        /**
         * 返回此class对象对应类的带指定参数的构造器，与构造器的访问权限无关
         */
        constructor = (Constructor<BasicClass>) basicClass.getDeclaredConstructor(Integer.class, String.class);
        System.out.println(constructor);

        /**
         * 返回此class对象对应类的所有构造器，与构造器的访问权限无关
         */
        constructors = (Constructor<BasicClass>[]) basicClass.getDeclaredConstructors();
        System.out.println(constructors);

    }

}
