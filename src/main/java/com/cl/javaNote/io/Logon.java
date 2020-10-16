package com.cl.javaNote.io;//: io/Logon.java
// Demonstrates the "transient" keyword.

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.cl.javaNote.util.Print.print;

/**
 * 在Serializable中使用transient 实现类似Externializable的效果
 * <p>
 * transient防止字段被序列化
 * <p>
 * 由于Externalizable对象在默认情况下不保存任何字段，所以transient必须配合Serializable使用
 */
public class Logon implements Serializable {
    private Date date = new Date();//反序列化时，并不会重新生成值
    private String username;
    private transient String password;

    public Logon(String name, String pwd) {
        username = name;
        password = pwd;
    }

    public String toString() {
        return "logon info: \n   username: " + username +
                "\n   date: " + date + "\n   password: " + password;
    }

    public static void main(String[] args) throws Exception {
        Logon a = new Logon("Hulk", "myLittlePony");
        print("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(
                new FileOutputStream("Logon.out"));
        o.writeObject(a);
        o.close();
        TimeUnit.SECONDS.sleep(1); // Delay
        // Now get them back:
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("Logon.out"));
        print("Recovering object at " + new Date());
        a = (Logon) in.readObject();
        print("logon a = " + a);
    }
} /* Output: (Sample)
logon a = logon info:
   username: Hulk
   date: Sat Nov 19 15:03:26 MST 2005
   password: myLittlePony
Recovering object at Sat Nov 19 15:03:28 MST 2005
logon a = logon info:
   username: Hulk
   date: Sat Nov 19 15:03:26 MST 2005
   password: null
*///:~
