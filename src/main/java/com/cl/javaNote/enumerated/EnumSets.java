//: enumerated/EnumSets.java
// Operations on EnumSets
package com.cl.javaNote.enumerated;

import java.util.EnumSet;

import static com.cl.javaNote.enumerated.AlarmPoints.*;
import static com.cl.javaNote.util.Print.*;

/**
 * 演示EnumSet的功效
 * EnumSet中的元素必须是一个enum元素
 * EnumSet的基础是long 可接受不超过64个enum元素
 * EnumSet的of()方法重载多次 可接受不同长度的参数集
 * enum定义时的次序决定了其在EnumSet中的顺序
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty set 初始化
        points.add(BATHROOM);
        print(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));//赋值初始化方式
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);
        points = EnumSet.complementOf(points);
        print(points);
    }
} /* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
*///:~
