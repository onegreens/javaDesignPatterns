package com.cl.description;

import com.cl.description.base.Beverage;
import com.cl.description.base.CondimentDecorator;
import com.cl.description.beverage.DarkRoast;
import com.cl.description.beverage.Espresso;
import com.cl.description.beverage.HouseBlend;
import com.cl.description.condiment.Mocha;
import com.cl.description.condiment.Soy;
import com.cl.description.condiment.Whip;

/**
 * Created by cl on 2017/6/23.
 */
public class test {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println("描述:"+beverage.getDescription()+"价格:"+beverage.cost());

        Beverage beverage1 = new DarkRoast();
        beverage1 = new Mocha(beverage1);
        beverage1 = new Soy(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println("描述:"+beverage1.getDescription()+"价格:"+beverage1.cost());


        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Soy(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println("描述:"+beverage2.getDescription()+"价格:"+beverage2.cost());

    }
}
