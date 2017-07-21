package com.cl.pattern.adapter.entity;

/**
 * Created by cl on 2017/7/7.
 */
public class WildTurkey implements Turkey {
    public void fly() {
        System.out.println("WildTurkey fly a short distance");
    }

    public void gobble() {
        System.out.println("WildTurkey gobble");

    }
}
