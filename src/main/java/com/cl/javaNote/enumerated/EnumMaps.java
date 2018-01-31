//: enumerated/EnumMaps.java
// Basics of EnumMaps.
package com.cl.javaNote.enumerated;

import java.util.EnumMap;
import java.util.Map;

import static com.cl.javaNote.enumerated.AlarmPoints.*;
import static com.cl.javaNote.util.Print.*;

interface Command { void action(); }

/**
 * EnumMap要求其中的键（key）必须来自一个enum
 * EnumMap内部可由数组实现 所以查询速度快
 * EnumMap允许改变值对象，而常量相关方法在编译器就固定了
 *
 */
public class EnumMaps {
  public static void main(String[] args) {
    EnumMap<AlarmPoints,Command> em =
      new EnumMap<AlarmPoints,Command>(AlarmPoints.class);
    em.put(KITCHEN, new Command() {
      public void action() { print("Kitchen fire!"); }
    });
    em.put(BATHROOM, new Command() {
      public void action() { print("Bathroom alert!"); }
    });
    for(Map.Entry<AlarmPoints,Command> e : em.entrySet()) {
      printnb(e.getKey() + ": ");
      e.getValue().action();
    }
    try { // If there's no value for a particular key:
      em.get(UTILITY).action();
    } catch(Exception e) {
      print(e);
    }
  }
} /* Output:
BATHROOM: Bathroom alert!
KITCHEN: Kitchen fire!
java.lang.NullPointerException
*///:~
