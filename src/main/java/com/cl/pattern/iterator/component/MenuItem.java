package com.cl.pattern.iterator.component;

import java.util.Iterator;

/**
 * Created by cl on 2017/7/24.
 */
public class MenuItem extends MenuComponent {
    private String name;
    private double price;
    private String description;
    private boolean vegetarian;

    public MenuItem(String name, double price, String description, boolean vegetarian) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.vegetarian = vegetarian;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public void print() {
        System.out.println("MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", vegetarian=" + vegetarian +
                '}');
    }

    public Iterator createIterator(){
        return new NullIterator();
    }
}
