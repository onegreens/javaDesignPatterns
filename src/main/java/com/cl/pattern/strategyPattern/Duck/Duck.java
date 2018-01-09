package com.cl.pattern.strategyPattern.Duck;

import com.cl.pattern.strategyPattern.Fly.FlyBehavior;
import com.cl.pattern.strategyPattern.quack.QuackBehavior;

/**
 * Created by cl on 2017/6/17.
 * 鸭子超类
 */
public abstract class Duck {

    //添加鸣叫行为
    QuackBehavior  quackBehavior;

    //添加飞行行为
    FlyBehavior flyBehavior;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("all duck float,even decoys!");
    }

    //添加set方法  可以动态的改变属性

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
