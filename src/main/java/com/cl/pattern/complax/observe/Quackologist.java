package com.cl.pattern.complax.observe;

/**
 * Created by cl on 2017/8/2.
 */
public class Quackologist implements Observer {
    public void update(QuackObservable quackObservable) {
        System.out.println(quackObservable+"被通知了");
    }
}
