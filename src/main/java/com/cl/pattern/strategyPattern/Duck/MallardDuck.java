package com.cl.pattern.strategyPattern.Duck;

import com.cl.pattern.strategyPattern.Fly.impl.FlyWithWings;
import com.cl.pattern.strategyPattern.quack.impl.Quack;

/**
 * Created by cl on 2017/6/17.
 * 具体的鸭子类型
 */
public class MallardDuck extends Duck {


    public MallardDuck() {
        flyBehavier = new FlyWithWings();
        quackBehavier = new Quack();
    }

    public void display() {
        System.out.println("i'm  real mallardDuck");
    }

    public static  void main(String[] args){
        Duck duck = new MallardDuck();
        duck.performFly();
        duck.performQuack();
        duck.display();
    }
}
