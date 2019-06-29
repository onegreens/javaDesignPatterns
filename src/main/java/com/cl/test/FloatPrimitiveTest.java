package com.cl.test;

import java.math.BigDecimal;

public class FloatPrimitiveTest {
    public static void main1(String[] args) {
        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        if (a == b) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main2(String[] args) {
        Float a = Float.valueOf(1.0f - 0.9f);
        Float b = Float.valueOf(0.9f - 0.8f);
        if (a.equals(b)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0.1);
        System.out.println(a);
        BigDecimal b = new BigDecimal("0.1");
        System.out.println(b);
    }
}
