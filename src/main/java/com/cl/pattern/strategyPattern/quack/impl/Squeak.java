package com.cl.pattern.strategyPattern.quack.impl;

import com.cl.pattern.strategyPattern.quack.QuackBehavier;

/**
 * Created by cl on 2017/6/17.
 */
public class Squeak implements QuackBehavier {
    public void quack() {
        System.out.println("squeak");
    }
}
