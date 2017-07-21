package com.cl.pattern.strategyPattern.Duck;

import com.cl.pattern.strategyPattern.Fly.impl.FlyRocketPowered;
import com.cl.pattern.strategyPattern.quack.impl.MuteQuack;
import com.cl.pattern.strategyPattern.quack.impl.Quack;

/**
 * Created by cl on 2017/6/17.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavier = new FlyRocketPowered();
        quackBehavier = new Quack();
    }

    public void display() {
        System.out.println("i'm modelDuck");
    }

    public static  void main(String[] args){
        Duck duck = new ModelDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();
        duck.setQuackBehavier(new MuteQuack());//动态修改行为
        duck.performQuack();
    }
}
