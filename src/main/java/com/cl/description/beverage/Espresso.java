package com.cl.description.beverage;

import com.cl.description.base.Beverage;

/**
 * Created by cl on 2017/6/23.
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    public double cost() {
        return 1.99;
    }
}
