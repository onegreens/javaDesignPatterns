package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel9.java
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.

/**
 * 在匿名类中定义字段时。还能够对其执行初始化操作
 */
public class Parcel9 {
  // Argument must be final to use inside
  // anonymous inner class:
  public Destination destination(final String dest) {
    return new Destination() {
      private String label = dest;
      public String readLabel() { return label; }
    };
  }
  public static void main(String[] args) {
    Parcel9 p = new Parcel9();
    Destination d = p.destination("Tasmania");
  }
} ///:~
