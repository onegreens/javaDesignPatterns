package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel8.java
// Calling the base-class constructor.

/**
 * 在Parcel7基础上为构造器添加参数
 */
public class Parcel8 {
  public Wrapping wrapping(int x) {
    // Base constructor call:
    return new Wrapping(x) { // Pass constructor argument.
      public int value() {
        return super.value() * 47;
      }
    }; // Semicolon required
  }
  public static void main(String[] args) {
    Parcel8 p = new Parcel8();
    Wrapping w = p.wrapping(10);
  }
} ///:~
