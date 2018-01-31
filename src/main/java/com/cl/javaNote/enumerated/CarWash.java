package com.cl.javaNote.enumerated;//: enumerated/CarWash.java

import java.util.EnumSet;

import static com.cl.javaNote.util.Print.*;

/**
 * 一个使用enum方法的实例
 * 洗车的例子：每个顾客在洗车的时候，都有一个选择的菜单，每个选择对应不同的动作。
 *            可以将一个常量相关的方法关联到一个选择上，再使用一个EnumSet来保存客户的选择
 *
 * 注意点：EnumSet添加Enum的次序不决定其输出的次序，其输出的次序决定在于Enum定义时的次序
 *
 */
public class CarWash {
  public enum Cycle {
    UNDERBODY {
      void action() { print("Spraying the underbody"); }
    },
    WHEELWASH {
      void action() { print("Washing the wheels"); }
    },
    PREWASH {
      void action() { print("Loosening the dirt"); }
    },
    BASIC {
      void action() { print("The basic wash"); }
    },
    HOTWAX {
      void action() { print("Applying hot wax"); }
    },
    RINSE {
      void action() { print("Rinsing"); }
    },
    BLOWDRY {
      void action() { print("Blowing dry"); }
    };
    abstract void action();
  }
  EnumSet<Cycle> cycles =
    EnumSet.of(Cycle.BASIC, Cycle.RINSE);
  public void add(Cycle cycle) { cycles.add(cycle); }
  public void washCar() {
    for(Cycle c : cycles)
      c.action();
  }
  public String toString() { return cycles.toString(); }
  public static void main(String[] args) {
    CarWash wash = new CarWash();
    print(wash);
    wash.washCar();
    // Order of addition is unimportant:
    wash.add(Cycle.BLOWDRY);
    wash.add(Cycle.BLOWDRY); // Duplicates ignored
    wash.add(Cycle.RINSE);
    wash.add(Cycle.HOTWAX);
    print(wash);
    wash.washCar();
  }
} /* Output:
[BASIC, RINSE]
The basic wash
Rinsing
[BASIC, HOTWAX, RINSE, BLOWDRY]
The basic wash
Applying hot wax
Rinsing
Blowing dry
*///:~
