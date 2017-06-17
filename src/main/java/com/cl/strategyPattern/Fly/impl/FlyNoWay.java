package com.cl.strategyPattern.Fly.impl;

import com.cl.strategyPattern.Fly.FlyBehavier;

/**
 * Created by cl on 2017/6/17.
 * 不能飞
 */
public class FlyNoWay implements FlyBehavier {
    public void fly() {
        System.out.println("i can't fly!!!");
    }
}
