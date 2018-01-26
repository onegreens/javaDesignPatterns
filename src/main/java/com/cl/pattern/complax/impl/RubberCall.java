package com.cl.pattern.complax.impl;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.observe.Observable;
import com.cl.pattern.complax.observe.Observer;

/**
 * Created by cl on 2017/8/1.
 */
public class RubberCall implements Quackable {
    public void quack() {
        System.out.println("橡皮鸭的叫声音。。。");
    }  Observable observable;

    public RubberCall() {
        this.observable = new Observable(this);
    }

    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }
}
