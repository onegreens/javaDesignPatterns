package com.cl.factory.entity;

import java.util.ArrayList;

/**
 * Created by cl on 2017/6/28.
 */
public abstract class Pizza {

    String name;
    String dough;
    String sause;
    ArrayList topping = new ArrayList();

    public void prepare() {
        System.out.println("preparing" +  name);
        System.out.println("Tossing dough");
        System.out.println("Add sause");
        System.out.println("adding topping");
        for (int i = 0; i < topping.size(); i++) {
            System.out.println("  " + topping.get(i));
        }
    }

    public void bake() {
        System.out.println("bake for 25 minutes at 350");
    }

    public void cut() {
        System.out.println("cut pizza into diagonal slices");
    }

    public void box() {
        System.out.println("place pizza in offical Pizzastore box");
    }

    String getName(){
        return name;
    }

}
