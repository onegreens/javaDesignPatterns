package com.cl.javaNote.enumerated;//: enumerated/OverrideConstantSpecific.java

import static com.cl.javaNote.util.Print.*;

/**
 * 其他覆写常量相关方法的方式
 *
 */
public enum OverrideConstantSpecific {
  NUT, BOLT,
  WASHER {
    void f() { print("Overridden method"); }
  };
  void f() { print("default behavior"); }//这算是默认方法，然后会被enum中的方法覆写
  //因为无法直接使用enum实例中的方法，所以需要在定义时，先声明该方法
  //就像是enum是一个超类，而enum实例是其实现类
  public static void main(String[] args) {
    for(OverrideConstantSpecific ocs : values()) {
      printnb(ocs + ": ");
      ocs.f();
    }
  }
} /* Output:
NUT: default behavior
BOLT: default behavior
WASHER: Overridden method
*///:~
