//: generics/Holder1.java
package com.cl.javaNote.generics;
class Automobile {}

/**
 * 只能持有一个类型的类
 */
public class Holder1 {
  private Automobile a;
  public Holder1(Automobile a) { this.a = a; }
  Automobile get() { return a; }
} ///:~
