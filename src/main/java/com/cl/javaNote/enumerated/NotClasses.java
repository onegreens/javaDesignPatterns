package com.cl.javaNote.enumerated;//: enumerated/NotClasses.java
// {Exec: javap -c LikeClasses}

import static com.cl.javaNote.util.Print.print;

/**
 * 不能将enum实例作为一个类型来使用
 * 因为每个enum元素都是一个LikeClasses类型的static final 实例
 */
enum LikeClasses {
  WINKEN { void behavior() { print("Behavior1"); } },
  BLINKEN { void behavior() { print("Behavior2"); } },
  NOD { void behavior() { print("Behavior3"); } };
  abstract void behavior();
}

public class NotClasses {
  // void f1(LikeClasses.WINKEN instance) {} // Nope
} /* Output:
Compiled from "NotClasses.java"
abstract class LikeClasses extends java.lang.Enum{
public static final LikeClasses WINKEN;

public static final LikeClasses BLINKEN;

public static final LikeClasses NOD;
...
*///:~
