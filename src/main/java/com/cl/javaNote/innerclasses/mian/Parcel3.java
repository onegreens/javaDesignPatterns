package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel3.java
// Using .new to create instances of inner classes.

/**
 * 如果创建的是静态内部类，那么它就不需要对外部类对象的引用
 */
public class Parcel3 {
  class Contents {
    private int i = 11;
    public int value() { return i; }
  }
  class Destination {
    private String label;
    Destination(String whereTo) { label = whereTo; }
    String readLabel() { return label; }
  }
  public static void main(String[] args) {
    Parcel3 p = new Parcel3();
    // Must use instance of outer class
    // to create an instance of the inner class:
    Parcel3.Contents c = p.new Contents();
    Parcel3.Destination d = p.new Destination("Tasmania");
  }
} ///:~
