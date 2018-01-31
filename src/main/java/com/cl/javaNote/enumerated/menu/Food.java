//: enumerated/menu/Food.java
// Subcategorization of enums within interfaces.
package com.cl.javaNote.enumerated.menu;

/**
 * 在一个接口内部，创建实现该接口的枚举，以此对元素进行分组，可以达到枚举元素分类组织的目的
 *
 * 对于enum而言，实现接口是使其子类化的唯一办法
 *
 */
public interface Food {
  enum Appetizer implements Food {
    SALAD, SOUP, SPRING_ROLLS;
  }
  enum MainCourse implements Food {
    LASAGNE, BURRITO, PAD_THAI,
    LENTILS, HUMMOUS, VINDALOO;
  }
  enum Dessert implements Food {
    TIRAMISU, GELATO, BLACK_FOREST_CAKE,
    FRUIT, CREME_CARAMEL;
  }
  enum Coffee implements Food {
    BLACK_COFFEE, DECAF_COFFEE, ESPRESSO,
    LATTE, CAPPUCCINO, TEA, HERB_TEA;
  }
} ///:~
