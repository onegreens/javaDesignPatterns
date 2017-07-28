package com.cl.pattern.iterator.component;

import java.util.Iterator;

/**
 * Created by cl on 2017/7/24.
 */
public class Waitress {
    MenuComponent menuComponent;

    public Waitress(MenuComponent menuComponent) {
        this.menuComponent = menuComponent;
    }

    public void print() {
        menuComponent.print();
    }

    public void printVetegetarainMenu() {
        Iterator iterator = menuComponent.createIterator();
        System.out.println("printVetegetarainMenu ============");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent) iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {

            }

        }
    }
}
