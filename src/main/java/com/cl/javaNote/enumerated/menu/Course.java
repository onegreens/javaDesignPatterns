//: enumerated/menu/Course.java
package com.cl.javaNote.enumerated.menu;
import com.cl.javaNote.util.Enums;

public enum Course {
  APPETIZER(Food.Appetizer.class),
  MAINCOURSE(Food.MainCourse.class),
  DESSERT(Food.Dessert.class),
  COFFEE(Food.Coffee.class);
  private Food[] values;
  private Course(Class<? extends Food> kind) {//将其对应的Class对象作为构造器的参数
    values = kind.getEnumConstants();//取得某个Food子类的所有enum实例
  }
  public Food randomSelection() {
    return Enums.random(values);
  }
} ///:~
