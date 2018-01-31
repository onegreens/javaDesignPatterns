package com.cl.javaNote.enumerated;


import com.cl.javaNote.initialization.Burrito;
import static com.cl.javaNote.initialization.Spiciness.*;

/**
 * Created by cl on 2018/1/29.
 * 将静态导入用于enum
 */
public class StaticTest {
    public static void main(String[] args) {
        System.out.println(new Burrito(FLAMING));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
