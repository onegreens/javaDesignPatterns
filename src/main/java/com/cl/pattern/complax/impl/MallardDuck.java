package com.cl.pattern.complax.impl;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.observe.Observable;
import com.cl.pattern.complax.observe.Observer;

/**
 * Created by cl on 2017/8/1.
 */
public class MallardDuck implements Quackable {
    Observable observable;

    public MallardDuck() {
        this.observable = new Observable(this);
    }

    public void quack() {
        System.out.println("绿头鸭的叫声。。。");
        notifyOberservers();
    }

    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyOberservers() {
        observable.notifyOberservers();
    }
}
