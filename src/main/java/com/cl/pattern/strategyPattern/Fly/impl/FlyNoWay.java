package com.cl.pattern.strategyPattern.Fly.impl;

import com.cl.pattern.strategyPattern.Fly.FlyBehavior;

/**
 * Created by cl on 2017/6/17.
 * 不能飞
 */
public class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("i can't fly!!!");
    }
}
