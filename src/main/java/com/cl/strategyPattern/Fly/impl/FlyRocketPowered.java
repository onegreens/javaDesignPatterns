package com.cl.strategyPattern.Fly.impl;

import com.cl.strategyPattern.Fly.FlyBehavier;

/**
 * Created by cl on 2017/6/17.
 */
public class FlyRocketPowered implements FlyBehavier {
    public void fly() {
        System.out.println("i'm fly with a rocket");
    }
}