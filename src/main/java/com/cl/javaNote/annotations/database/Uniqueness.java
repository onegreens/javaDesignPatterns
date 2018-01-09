//: annotations/database/Uniqueness.java
// Sample of nested annotations
package com.cl.javaNote.annotations.database;
//令嵌入的@Constraints注解中的unique()元素为true,并以此作为constraints()元素的默认值
public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
} ///:~
