package com.cl.javaNote.io;
// Simple use of Externalizable & a pitfall.

import java.io.*;

import static com.cl.javaNote.util.Print.print;
/**
 *
 */

/**
 * Externalizable和Serializable
 * Externalizable继承了Serializable接口，同时添加了writeExternal()和readExternal()方法
 * 这两个方法会在序列化和反序列化还原的过程中被自定调用
 * <p>
 * 对于Serializable对象，对象完全以它存储的二进制位为基础来构造，而不是调用构造器
 * 对于一个Externalizable对象，所有默认的构造器都会被调用，才能使Externalizable对象产生正确的行为
 * 所以需要设置构造器为public
 */


class Blip1 implements Externalizable {
    public Blip1() {
        print("Blip1 Constructor");
    }

    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("Blip1.writeExternal");
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip1.readExternal");
    }
}

class Blip2 implements Externalizable {
    Blip2() {
        print("Blip2 Constructor");
    }

    public void writeExternal(ObjectOutput out)
            throws IOException {
        print("Blip2.writeExternal");
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        print("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        print("Constructing objects:");
        Blip1 b1 = new Blip1();
        Blip2 b2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Blips.out"));
        print("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Blips.out"));
        print("Recovering b1:");
        b1 = (Blip1) in.readObject();
        // OOPS! Throws an exception:
        //由于Blip2的构造器不是public 因此产生异常
//! print("Recovering b2:");
//! b2 = (Blip2)in.readObject();
    }
} /* Output:
Constructing objects:
Blip1 Constructor
Blip2 Constructor
Saving objects:
Blip1.writeExternal
Blip2.writeExternal
Recovering b1:
Blip1 Constructor
Blip1.readExternal
*///:~
