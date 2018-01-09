package com.cl.pattern.strategyPattern.Fly.impl;

import com.cl.pattern.strategyPattern.Fly.FlyBehavior;

/**
 * Created by cl on 2017/6/17.
 */
public class FlyRocketPowered implements FlyBehavior {
    public void fly() {
        System.out.println("i'm fly with a rocket");
    }
}
