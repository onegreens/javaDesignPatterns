package com.cl.factory;

import com.cl.factory.entity.CalmPizza;
import com.cl.factory.entity.ChessePizza;
import com.cl.factory.entity.Pizza;
import com.cl.factory.entity.VeggiePizza;

/**
 * Created by cl on 2017/6/28.
 * 一个披萨工厂
 */
public class SimplePizzaFactory {

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("chesse".equals(type)) {
            pizza = new ChessePizza();
        } else if ("calm".equals(type)) {
            pizza = new CalmPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
