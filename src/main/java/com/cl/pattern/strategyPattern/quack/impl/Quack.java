package com.cl.pattern.strategyPattern.quack.impl;

import com.cl.pattern.strategyPattern.quack.QuackBehavior;

/**
 * Created by cl on 2017/6/17.
 * 有声
 */
public class Quack implements QuackBehavior {
    public void quack() {
        System.out.println("Quack");
    }
}
