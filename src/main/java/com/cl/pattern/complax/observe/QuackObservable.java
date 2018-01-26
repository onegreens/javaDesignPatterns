package com.cl.pattern.complax.observe;



/**
 * Created by cl on 2017/8/2.
 */
public interface QuackObservable {

    public void registerObserver(Observer observer);

    public void notifyObservers();
}
