package com.cl.pattern.complax.adapter;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.observe.Observer;

/**
 * Created by cl on 2017/8/1.
 */
public class GoodAdapter implements Quackable {
    Goose goose;

    public GoodAdapter(Goose goose) {
        this.goose = goose;
    }

    public void quack() {
        goose.hood();
    }

    public void registerObserver(Observer observer) {

    }

    public void notifyOberservers() {

    }
}
