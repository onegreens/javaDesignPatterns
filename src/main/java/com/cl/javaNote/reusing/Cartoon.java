package com.cl.javaNote.reusing;//: reusing/Cartoon.java
// Constructor calls during inheritance.

import static com.cl.javaNote.util.Print.print;

class Art {
  Art() { print("Art constructor"); }
}

class Drawing extends Art {
  Drawing() { print("Drawing constructor"); }
}

/**
 * 初始化基类
 * 在实例化子类时，父类构造方法的初始化过程
 * 由最初的基类向外扩散的形式调用构造方法
 */
public class Cartoon extends Drawing {
  public Cartoon() { print("Cartoon constructor"); }
  public static void main(String[] args) {
    Cartoon x = new Cartoon();
  }
} /* Output:
Art constructor
Drawing constructor
Cartoon constructor
*///:~
