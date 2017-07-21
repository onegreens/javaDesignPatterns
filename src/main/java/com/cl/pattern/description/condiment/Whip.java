package com.cl.pattern.description.condiment;

import com.cl.pattern.description.base.Beverage;
import com.cl.pattern.description.base.CondimentDecorator;

/**
 * Created by cl on 2017/6/23.
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription()+",Whip";
    }

    public double cost() {
        return .3+ beverage.cost();
    }
}
