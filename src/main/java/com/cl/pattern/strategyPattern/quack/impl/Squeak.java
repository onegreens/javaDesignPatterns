package com.cl.pattern.strategyPattern.quack.impl;

import com.cl.pattern.strategyPattern.quack.QuackBehavior;

/**
 * Created by cl on 2017/6/17.
 */
public class Squeak implements QuackBehavior {
    public void quack() {
        System.out.println("squeak");
    }
}
