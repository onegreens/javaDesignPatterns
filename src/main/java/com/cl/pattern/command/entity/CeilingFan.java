package com.cl.pattern.command.entity;

/**
 * Created by cl on 2017/7/3.
 * 风扇
 */
public class CeilingFan {

    public static final int HIGH = 3;
    public static final int MEDIUN = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    String location;
    int speed;

    public CeilingFan(String location) {
        this.location = location;
        speed = OFF;
    }

    public void high() {
        speed = HIGH;
        System.out.println("风速为high");
    }

    public void medium() {
        speed = MEDIUN;
        System.out.println("风速为medium");

    }

    public void low() {
        speed = LOW;
        System.out.println("风速为low");

    }

    public int getSpeed(){
        return speed;

    }

    public void off() {
        speed = OFF;
        System.out.println("风速为off");

    }
}
