package com.cl.pattern.description.beverage;

import com.cl.pattern.description.base.Beverage;

/**
 * Created by cl on 2017/6/23.
 */
public class DarkRoast extends Beverage {

    public DarkRoast() {
        description = "DarkRoast";
    }

    public double cost() {
        return 1.6;
    }
}
