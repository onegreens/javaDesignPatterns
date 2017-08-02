package com.cl.pattern.complax.test;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.adapter.GoodAdapter;
import com.cl.pattern.complax.adapter.Goose;
import com.cl.pattern.complax.description.QuackCountor;
import com.cl.pattern.complax.factory.AbstractDuckFactory;
import com.cl.pattern.complax.factory.DuckFactory;
import com.cl.pattern.complax.group.Flock;
import com.cl.pattern.complax.impl.DuckCall;
import com.cl.pattern.complax.impl.MallardDuck;
import com.cl.pattern.complax.impl.RedheadDuck;
import com.cl.pattern.complax.impl.RubberCall;

/**
 * Created by cl on 2017/8/1.
 */
public class DuckSimulator1 {
    public static void main(String[] args) {
        DuckSimulator1 duckSimulator = new DuckSimulator1();
        duckSimulator.simulator();
    }

    void simulator() {

    }

    void simulator(Quackable quackable) {
        quackable.quack();
    }
}
