package com.cl.pattern.factory.store;

import com.cl.pattern.factory.entity.Pizza;

/**
 * Created by cl on 2017/6/28.
 * 披萨商店
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.bake();
        pizza.box();
        pizza.cut();
        pizza.prepare();

        return pizza;
    }

    abstract Pizza createPizza(String type);


}
