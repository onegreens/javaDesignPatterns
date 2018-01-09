//: net/mindview/util/Sets.java
package com.cl.javaNote.util;

import java.util.HashSet;
import java.util.Set;

public class Sets {
  /**
   * 合并
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.addAll(b);
    return result;
  }

  /**
   * 交集
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T>
  Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = new HashSet<T>(a);
    result.retainAll(b);
    return result;
  }

  // Subtract subset from superset:

  /**
   * 去除
   * @param superset
   * @param subset
   * @param <T>
   * @return
   */
  public static <T> Set<T>
  difference(Set<T> superset, Set<T> subset) {
    Set<T> result = new HashSet<T>(superset);
    result.removeAll(subset);
    return result;
  }
  // Reflexive--everything not in the intersection:

  /**
   * 反交集
   * @param a
   * @param b
   * @param <T>
   * @return
   */
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
} ///:~
