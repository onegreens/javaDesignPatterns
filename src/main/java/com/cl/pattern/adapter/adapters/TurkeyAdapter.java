package com.cl.pattern.adapter.adapters;

import com.cl.pattern.adapter.entity.Duck;
import com.cl.pattern.adapter.entity.Turkey;

/**
 * Created by cl on 2017/7/7.
 * 简易适配器 turkey --> duck
 */
public class TurkeyAdapter implements Duck {

    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }

    public void quack() {

        turkey.gobble();

    }
}
