package com.cl.pattern.complax.group;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.observe.Observer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cl on 2017/8/2.
 */
public class Flock implements Quackable {
    ArrayList quackers = new ArrayList();

    public void add(Quackable quackable) {
        quackers.add(quackable);
    }

    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()){
            Quackable quackable = (Quackable) iterator.next();
            quackable.quack();;
        }
    }

    public void registerObserver(Observer observer) {

    }

    public void notifyOberservers() {

    }
}
