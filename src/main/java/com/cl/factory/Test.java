package com.cl.factory;

import com.cl.factory.store.MyStyleStore;
import com.cl.factory.store.PizzaStore;

/**
 * Created by cl on 2017/6/29.
 */
public class Test {

    public static void main(String[] args) {
        PizzaStore pizzaStore = new MyStyleStore();
        pizzaStore.orderPizza("chesses");

    }
}
