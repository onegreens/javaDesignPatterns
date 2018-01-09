//: net/mindview/util/TwoTuple.java
package com.cl.javaNote.generics;

/**
 * 二维元组，能够持有两个对象
 * @param <A>
 * @param <B>
 */
public class TwoTuple<A,B> {
  public final A first;
  public final B second;
  public TwoTuple(A a, B b) { first = a; second = b; }
  public String toString() {
    return "(" + first + ", " + second + ")";
  }
} ///:~
