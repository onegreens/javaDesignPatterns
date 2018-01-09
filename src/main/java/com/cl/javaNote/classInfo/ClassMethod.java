package com.cl.javaNote.classInfo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by cl on 2017/12/1.
 *
 * 获取类成员方法
 */
public class ClassMethod {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");

        /**
         * 返回此class对象对应类的带指定形参的public方法
         */
        Method method;
        method = basicClass.getMethod("getId");
        System.out.println(method);

        method = basicClass.getMethod("setId", Integer.class);
        System.out.println(method);

        /**
         * 返回此class对象所表示的类的所有public方法
         * 还有默认方法
         */
        Method[] methods;
        methods = basicClass.getMethods();
        System.out.println(methods);

        /**
         *返回此class对象对应类的带指定形参的方法，与方法访问权限无关
         */
        method = basicClass.getDeclaredMethod("getId");
        System.out.println(method);

        method = basicClass.getDeclaredMethod("setId", Integer.class);
        System.out.println(method);

        /**
         * 返回此class对象对应类的全部方法，与方法的访问权限无关
         */
        methods = basicClass.getDeclaredMethods();
        System.out.println(methods);
    }

}
