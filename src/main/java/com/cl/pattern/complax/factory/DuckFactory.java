package com.cl.pattern.complax.factory;

import com.cl.pattern.complax.Quackable;
import com.cl.pattern.complax.adapter.GoodAdapter;
import com.cl.pattern.complax.adapter.Goose;
import com.cl.pattern.complax.impl.DuckCall;
import com.cl.pattern.complax.impl.MallardDuck;
import com.cl.pattern.complax.impl.RedheadDuck;
import com.cl.pattern.complax.impl.RubberCall;

/**
 * Created by cl on 2017/8/2.
 */
public class DuckFactory extends AbstractDuckFactory {
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    public Quackable createRubberCall() {
        return new RubberCall();
    }
    public Quackable createGoose() {
        return new GoodAdapter(new Goose());
    }
}
