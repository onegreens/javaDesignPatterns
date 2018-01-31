//: enumerated/menu/TypeOfFood.java
package com.cl.javaNote.enumerated.menu;
import static com.cl.javaNote.enumerated.menu.Food.*;

/**
 * 如果enum类实现了Food接口，则可以将其向上转型为Food
 */
public class TypeOfFood {
  public static void main(String[] args) {
    Food food = Appetizer.SALAD;
    food = MainCourse.LASAGNE;
    food = Dessert.GELATO;
    food = Coffee.CAPPUCCINO;
  }
} ///:~
