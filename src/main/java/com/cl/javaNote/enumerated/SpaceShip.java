package com.cl.javaNote.enumerated;

//: enumerated/SpaceShip.java

/**
 * 覆盖enum的方法
 * toString() 通过电泳name()方法获取到SpaceShip的名字，然后就将其修改为只有首字母为大写的字符
 */
public enum SpaceShip {
  SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;
  public String toString() {
    String id = name();
    String lower = id.substring(1).toLowerCase();
    //substring(index)返回自index开始的所有字符
    return id.charAt(0)+lower;
  }
  public static void main(String[] args) {
    for(SpaceShip s : values()) {
      System.out.println(s);
    }
  }
} /* Output:
Scout
Cargo
Transport
Cruiser
Battleship
Mothership
*///:~
