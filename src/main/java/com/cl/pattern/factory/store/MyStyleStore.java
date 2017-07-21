package com.cl.pattern.factory.store;

import com.cl.pattern.factory.entity.CalmPizza;
import com.cl.pattern.factory.entity.ChessePizza;
import com.cl.pattern.factory.entity.Pizza;
import com.cl.pattern.factory.entity.VeggiePizza;

/**
 * Created by cl on 2017/6/29.
 */
public class MyStyleStore extends PizzaStore {

    Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("chesses".equals(type)) {
            pizza = new ChessePizza();
        } else if ("calm".equals(type)) {
            pizza = new CalmPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
