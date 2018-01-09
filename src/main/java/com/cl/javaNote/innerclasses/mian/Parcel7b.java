package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel7b.java
// Expanded version of Parcel7.java

/**
 * 实现Parcel7 的另外一种方式
 */
public class Parcel7b {
  class MyContents implements Contents {
    private int i = 11;
    public int value() { return i; }
  }
  public Contents contents() { return new MyContents(); }
  public static void main(String[] args) {
    Parcel7b p = new Parcel7b();
    Contents c = p.contents();
  }
} ///:~
