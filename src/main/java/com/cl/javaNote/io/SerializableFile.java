package com.cl.javaNote.io;

import java.io.*;

/**
 * Created by cl on 2017/11/28.
 * 对象序列化
 * 将对象序列化之后存到某文件
 * 反序列化则将该文件中的数据生成对象
 */
public class SerializableFile {
    /**
     * 序列化
     * 通过文件
     *
     * @param object
     * @param path
     */
    static void doSerializable(Object object, String path) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
        out.writeObject(object);
        out.close();
    }

    /**
     * 反序列化
     * 通过文件
     *
     * @param path
     * @return
     */
    static Object upSerializable(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        Object object = inputStream.readObject();
        return object;
    }

    /**
     * 序列化
     * 通过字节数组
     *
     * @param object
     */
    static ByteArrayOutputStream doSerializable(Object object) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        out.writeObject(object);
        out.close();
        return outputStream;
    }

    /**
     * 反序列化
     * 通过文件
     *
     * @param bytes 可通过 ByteArrayOutputStream.toByteArray()获取
     * @return
     */
    static Object upSerializable(byte[] bytes) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Object object = inputStream.readObject();
        return object;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSerializable test = new TestSerializable("张三");
        SerializableFile.doSerializable(test,"/test.out");
        TestSerializable upTest1 = (TestSerializable) SerializableFile.upSerializable("/test.out");
        System.out.println("1:"+upTest1.toString());

//        ByteArrayOutputStream outputStream = SerializableFile.doSerializable(test);
//        TestSerializable upTest = (TestSerializable) SerializableFile.upSerializable(outputStream.toByteArray());
//        System.out.println(upTest.toString());
    }
}

class TestSerializable implements Serializable {
    private String name;

    public TestSerializable(String name) {
        this.name = name;
    }

    public TestSerializable() {
    }

    @Override
    public String toString() {
        return "TestSerializable{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


