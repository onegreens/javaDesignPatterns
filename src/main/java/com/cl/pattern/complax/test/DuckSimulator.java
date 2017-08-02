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
public class DuckSimulator {
    public static void main1(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulator1();
    }

    void simulator1() {
        Quackable mallardDuck = new QuackCountor(new MallardDuck());
        Quackable duckCall = new QuackCountor(new DuckCall());
        Quackable redheadDuck = new QuackCountor(new RedheadDuck());
        Quackable rubberCall = new QuackCountor(new RubberCall());
        Quackable goose = new GoodAdapter(new Goose());
        simulator(mallardDuck);
        simulator(redheadDuck);
        simulator(duckCall);
        simulator(rubberCall);
        simulator(goose);
        System.out.println("鸭子的叫声数量："+QuackCountor.getNumberOfQuacks());
    }


    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        AbstractDuckFactory abstractDuckFactory = new DuckFactory();
        duckSimulator.simulator(abstractDuckFactory);
    }

    void simulator(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable rubberCall = duckFactory.createRubberCall();
        Quackable goose = new GoodAdapter(new Goose());
        simulator(mallardDuck);
        simulator(redheadDuck);
        simulator(duckCall);
        simulator(rubberCall);
        simulator(goose);
        System.out.println("鸭子的叫声数量："+QuackCountor.getNumberOfQuacks());

        System.out.println("============");
        System.out.println("测试组合模式");
        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(duckCall);
        flock.add(redheadDuck);
        flock.add(rubberCall);
        flock.quack();
        simulator(flock);

    }

    void simulator(Quackable quackable) {
        quackable.quack();
    }
}
