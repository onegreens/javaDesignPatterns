package com.cl.pattern.adapter.adapters;

import com.cl.pattern.adapter.entity.Duck;
import com.cl.pattern.adapter.entity.Turkey;

/**
 * Created by cl on 2017/7/7.
 * 简易适配器 duck --> turkey
 */
public class DuckAdapter implements Turkey {

    Duck duck;

    public DuckAdapter(Duck duck) {
        this.duck = duck;
    }

    public void fly() {
        for (int i = 0; i < 5; i++) {
            duck.fly();
        }
    }

    public void gobble () {

        duck.quack();

    }
}
