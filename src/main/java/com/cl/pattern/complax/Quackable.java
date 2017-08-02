package com.cl.pattern.complax;

import com.cl.pattern.complax.observe.QuackObservable;

/**
 * Created by cl on 2017/8/1.
 */
public interface Quackable extends QuackObservable {
    public void quack();
}
