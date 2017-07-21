package com.cl.pattern.strategyPattern.quack.impl;

import com.cl.pattern.strategyPattern.quack.QuackBehavier;

/**
 * Created by cl on 2017/6/17.
 * 有声
 */
public class Quack implements QuackBehavier {
    public void quack() {
        System.out.println("Quack");
    }
}
