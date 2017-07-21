package com.cl.pattern.description.condiment;

import com.cl.pattern.description.base.Beverage;
import com.cl.pattern.description.base.CondimentDecorator;

/**
 * Created by cl on 2017/6/23.
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription()+",Soy";
    }

    public double cost() {
        return 5+ beverage.cost();
    }
}
