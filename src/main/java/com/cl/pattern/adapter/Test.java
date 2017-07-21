package com.cl.pattern.adapter;

import com.cl.pattern.adapter.adapters.TurkeyAdapter;
import com.cl.pattern.adapter.entity.Duck;
import com.cl.pattern.adapter.entity.MallardDuck;
import com.cl.pattern.adapter.entity.Turkey;
import com.cl.pattern.adapter.entity.WildTurkey;

/**
 * Created by cl on 2017/7/7.
 */
public class Test {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.fly();
        duck.quack();

        Turkey turkey = new WildTurkey();
        Duck duck1 = new TurkeyAdapter(turkey);
        duck1.quack();
        duck1.fly();
    }
}
