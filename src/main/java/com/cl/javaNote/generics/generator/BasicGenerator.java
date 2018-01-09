//: net/mindview/util/BasicGenerator.java
// Automatically create a Generator, given a class
// with a default (no-arg) constructor.
package com.cl.javaNote.generics.generator;

/**
 * Class<T> type的前提条件
 * 必须声明为public
 * 必须有默认的构造器（无参数的构造器）
 * @param <T>
 */
public class BasicGenerator<T> implements Generator<T> {
  private Class<T> type;
  public BasicGenerator(Class<T> type){ this.type = type; }
  public T next() {
    try {
      // Assumes type is a public class:
      return type.newInstance();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }
  // Produce a Default generator given a type token:
  public static <T> Generator<T> create(Class<T> type) {
    return new BasicGenerator<T>(type);
  }

  public static void main(String[] args) {
    Generator<CountedObject> gen =
            BasicGenerator.create(CountedObject.class);
    for(int i = 0; i < 5; i++)
      System.out.println(gen.next());
  }

} ///:~
