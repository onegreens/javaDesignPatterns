package com.cl.strategyPattern.Duck;

import com.cl.strategyPattern.Fly.FlyBehavier;
import com.cl.strategyPattern.quack.QuackBehavier;

/**
 * Created by cl on 2017/6/17.
 * 鸭子超类
 */
public abstract class Duck {

    //添加鸣叫行为
    QuackBehavier quackBehavier;

    //添加飞行行为
    FlyBehavier flyBehavier;

    public Duck() {
    }

    public abstract void display();

    public void performFly() {
        flyBehavier.fly();
    }

    public void performQuack() {
        quackBehavier.quack();
    }

    public void swim(){
        System.out.println("all duck float,even decoys!");
    }

    //添加set方法  可以动态的改变属性

    public void setQuackBehavier(QuackBehavier quackBehavier) {
        this.quackBehavier = quackBehavier;
    }

    public void setFlyBehavier(FlyBehavier flyBehavier) {
        this.flyBehavier = flyBehavier;
    }
}
