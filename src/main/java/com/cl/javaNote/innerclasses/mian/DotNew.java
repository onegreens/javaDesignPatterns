package com.cl.javaNote.innerclasses.mian;//: innerclasses/DotNew.java
// Creating an inner class directly using the .new syntax.

/**
 * 创建内部类对象
 * 必须使用外部类的对象来创建内部类对象
 *
 */
public class DotNew {
  public class Inner {}
  public static void main(String[] args) {
    DotNew dn = new DotNew();
    DotNew.Inner dni = dn.new Inner();
  }
} ///:~
