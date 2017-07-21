package com.cl.pattern.adapter.entity;

/**
 * Created by cl on 2017/7/7.
 */
public class MallardDuck implements Duck {
    public void fly() {
        System.out.println("MallardDuck fly");
    }

    public void quack() {
        System.out.println("MallardDuck quack");

    }
}
