package com.cl.javaNote.innerclasses.mian;//: innerclasses/AnonymousConstructor.java
// Creating a constructor for an anonymous inner class.

import static com.cl.javaNote.util.Print.*;

abstract class Base {
  public Base(int i) {
    print("Base constructor, i = " + i);
  }
  public abstract void f();
}

/**
 * 为匿名内部类创建一个参数构造器,无需定义参数final
 */
public class AnonymousConstructor {
  public static Base getBase(int i) {
    return new Base(i) {
      { print("Inside instance initializer"); }
      public void f() {
        print("In anonymous f()");
      }
    };
  }
  public static void main(String[] args) {
    Base base = getBase(47);
    base.f();
  }
} /* Output:
Base constructor, i = 47
Inside instance initializer
In anonymous f()
*///:~
