package com.cl.pattern.complax.factory;

import com.cl.pattern.complax.Quackable;

/**
 * Created by cl on 2017/8/2.
 */
public abstract class AbstractDuckFactory {
    public abstract Quackable createDuckCall();
    public abstract Quackable createMallardDuck();
    public abstract Quackable createRedheadDuck();
    public abstract Quackable createRubberCall();
}
