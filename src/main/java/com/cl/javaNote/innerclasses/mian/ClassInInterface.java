package com.cl.javaNote.innerclasses.mian;//: innerclasses/ClassInInterface.java
// {main: ClassInInterface$Test}

/**
 * 接口内部的类
 */
public interface ClassInInterface {
  void howdy();
  class Test implements ClassInInterface {
    public void howdy() {
      System.out.println("Howdy!");
    }
    public static void main(String[] args) {
      new Test().howdy();
    }
  }
} /* Output:
Howdy!
*///:~
