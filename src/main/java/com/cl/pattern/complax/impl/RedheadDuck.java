package com.cl.pattern.complax.impl;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.observe.Observable;
import com.cl.pattern.complax.observe.Observer;

/**
 * Created by cl on 2017/8/1.
 */
public class RedheadDuck implements Quackable {
    public void quack() {
        System.out.println("模拟器的叫声。。。");
    }

    Observable observable;

    public RedheadDuck() {
        this.observable = new Observable(this);
    }

    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }
}
