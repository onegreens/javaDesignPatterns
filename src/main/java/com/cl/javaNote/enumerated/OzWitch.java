package com.cl.javaNote.enumerated;//: enumerated/OzWitch.java
// The witches in the land of Oz.

import static com.cl.javaNote.util.Print.*;

/**
 * 枚举实例返回自身的描述
 * 需要操作：添加构造器，添加额外的方法
 * 枚举格式：  name(description);
 * 必须在最后添加一个分号
 */
public enum OzWitch {
  // Instances must be defined first, before methods:
  //实例必须在方法前定义
  WEST("Miss Gulch, aka the Wicked Witch of the West"),
  NORTH("Glinda, the Good Witch of the North"),
  EAST("Wicked Witch of the East, wearer of the Ruby " +
    "Slippers, crushed by Dorothy's house"),
  SOUTH("Good by inference, but missing");
  private String description;//自动接收枚举的描述
  // Constructor must be package or private access:构造器必须声明为私有
//在使用枚举的时候 通过 Instance instance = Instance.ENUM的方式创建实例，并没有使用到构造器
  private OzWitch(String description) {
    this.description = description;
  }
  public String getDescription() { return description; }
  public static void main(String[] args) {
    for(OzWitch witch : OzWitch.values())
      print(witch + ": " + witch.getDescription());
  }
} /* Output:
WEST: Miss Gulch, aka the Wicked Witch of the West
NORTH: Glinda, the Good Witch of the North
EAST: Wicked Witch of the East, wearer of the Ruby Slippers, crushed by Dorothy's house
SOUTH: Good by inference, but missing
*///:~
