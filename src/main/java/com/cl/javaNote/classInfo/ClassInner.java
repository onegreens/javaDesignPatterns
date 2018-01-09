package com.cl.javaNote.classInfo;

/**
 * Created by cl on 2017/12/1.
 */
public class ClassInner {
    /**
     * 获取该类内部类
     */
    public static void main1(String[] args) throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        Class<?>[] innerClass = basicClass.getDeclaredClasses();
        System.out.println(innerClass);
    }

    /**
     * 获取该类对象所在的外部类
     * 返回该Class对象对应类所在的外部类
     * 生成内部类时，使用$符号 即：BasicClass$InnerBasic
     */
    public static void main2(String[] args) throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass$InnerBasic");
        Class<?> externalClass = basicClass.getDeclaringClass();
        System.out.println(externalClass);
    }

    /**
     * 获取该类对象对应类所实现的接口
     * 返回该Class对象对应类所实现的全部接口
     */
    public static void main3(String[] args) throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        Class<?>[] externalClass = basicClass.getInterfaces();
        System.out.println(externalClass);
    }

    /**
     * 获取该类对象对应类所继承的父类
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main4(String[] args) throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        Class<?> externalClass = basicClass.getSuperclass();
        System.out.println(externalClass);
    }

    /**
     * 获取该类对象对应类的修饰符、所在包、类名等基本信息
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        int modifiers = basicClass.getModifiers();
        System.out.println("modifiers="+modifiers);

        Package packages = basicClass.getPackage();
        System.out.println("packages="+packages);

        String className = basicClass.getName();
        System.out.println("className="+className);

        String simpleName = basicClass.getSimpleName();
        System.out.println("simpleName="+simpleName);

        String canonicalName = basicClass.getCanonicalName();
        System.out.println("canonicalName="+canonicalName);
    }
}
