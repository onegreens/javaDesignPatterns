package com.cl.pattern.iterator.entity;

/**
 * Created by cl on 2017/7/21.
 */
public class MenuItem {
    String name;
    String description;
    boolean vegetarion;
    double price;

    public MenuItem(String name, String description, boolean vegetarion, double price) {
        this.name = name;
        this.description = description;
        this.vegetarion = vegetarion;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetarion() {
        return vegetarion;
    }

    public void setVegetarion(boolean vegetarion) {
        this.vegetarion = vegetarion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
