package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel5.java
// Nesting a class within a method.

/**
 * 定义在方法中的类
 */
public class Parcel5 {
    public Destination destination(String s) {
        class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            public String readLabel() {
                return label;
            }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
} ///:~
