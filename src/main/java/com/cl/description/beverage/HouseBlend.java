package com.cl.description.beverage;

import com.cl.description.base.Beverage;

/**
 * Created by cl on 2017/6/23.
 */
public class HouseBlend  extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    public double cost() {
        return .89;
    }
}
