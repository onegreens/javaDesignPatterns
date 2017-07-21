package com.cl.pattern.description.condiment;

import com.cl.pattern.description.base.Beverage;
import com.cl.pattern.description.base.CondimentDecorator;

/**
 * Created by cl on 2017/6/23.
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }

    public double cost() {
        return .20 + beverage.cost();
    }
}
