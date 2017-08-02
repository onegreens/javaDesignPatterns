package com.cl.pattern.complax.description;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.observe.Observer;

/**
 * Created by cl on 2017/8/2.
 */
public class QuackCountor implements Quackable {
    Quackable quackable;

    static int numberOfQuacks;

    public QuackCountor(Quackable quackable) {
        this.quackable = quackable;
    }

    public void quack() {
        quackable.quack();
        numberOfQuacks++;
    }

    public static int getNumberOfQuacks() {
        return numberOfQuacks;
    }

    public void registerObserver(Observer observer) {

    }

    public void notifyOberservers() {

    }
}
