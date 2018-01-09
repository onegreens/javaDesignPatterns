package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel7.java
// Returning an instance of an anonymous inner class.

/**
 * 方法将返回值的生成和表示这个返回值的类定义结合
 */
public class Parcel7 {
  public Contents contents() {
    return new Contents() { // Insert a class definition
      private int i = 11;
      public int value() { return i; }
    }; // Semicolon required in this case
  }
  public static void main(String[] args) {
    Parcel7 p = new Parcel7();
    Contents c = p.contents();
  }
} ///:~
