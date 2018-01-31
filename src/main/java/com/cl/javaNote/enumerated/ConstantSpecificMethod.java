package com.cl.javaNote.enumerated;//: enumerated/ConstantSpecificMethod.java

import java.text.DateFormat;
import java.util.Date;

/**
 * 为enum实例编写方法，赋予其不同的行为
 * 方式：需要为enum定义一个或者多个abstract方法，然后为每个enum实例实现该抽象方法
 */
public enum ConstantSpecificMethod {
  DATE_TIME {
    String getInfo() {
      return
        DateFormat.getDateInstance().format(new Date());
    }
  },
  CLASSPATH {
    String getInfo() {
      return System.getenv("CLASSPATH");
    }
  },
  VERSION {
    String getInfo() {
      return System.getProperty("java.version");
    }
  };
  abstract String getInfo();
  public static void main(String[] args) {
    for(ConstantSpecificMethod csm : values())
      System.out.println(csm.getInfo());//通过实例调用该方法
  }
} /* (Execute to see output) *///:~
