//: annotations/database/DBTable.java
package com.cl.javaNote.annotations.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//数据库表注解
@Target(ElementType.TYPE) // Applies to classes only 限定注解类型
@Retention(RetentionPolicy.RUNTIME)
public @interface DBTable {
  public String name() default "";//通过该元素为处理器创建数据库提供表的名字
} ///:~
