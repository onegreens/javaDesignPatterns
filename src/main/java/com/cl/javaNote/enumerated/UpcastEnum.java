package com.cl.javaNote.enumerated;//: enumerated/UpcastEnum.java
// No values() method if you upcast an enum

enum Search { HITHER, YON }

/**
  * 由于values()方法是由编译器添加的静态方法，所以将enum实例向上转型为Enum时，values()方法将不可以访问
    其替代方法则是 getEnumConstants();
 */
public class UpcastEnum {
  public static void main(String[] args) {
    Search[] vals = Search.values();
    Enum e = Search.HITHER; // Upcast
    // e.values(); // No values() in Enum
    for(Enum en : e.getClass().getEnumConstants())
      System.out.println(en);
  }
} /* Output:
HITHER
YON
*///:~
