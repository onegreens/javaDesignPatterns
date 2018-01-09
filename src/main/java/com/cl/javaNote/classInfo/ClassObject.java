package com.cl.javaNote.classInfo;

/**
 * 获取类对象
 *
 * @throws ClassNotFoundException
 */
public class ClassObject {

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * Class.forName()
         * 参数需要为完整的包路径
         */
        Class<?> basicClass = Class.forName("com.cl.javaNote.classInfo.BasicClass");
        System.out.println(basicClass);

        basicClass = new BasicClass().getClass();

        basicClass = BasicClass.class;

    }
}

