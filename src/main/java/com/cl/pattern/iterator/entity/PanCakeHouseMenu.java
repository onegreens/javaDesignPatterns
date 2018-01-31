package com.cl.pattern.iterator.entity;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by cl on 2017/7/21.
 */
public class PanCakeHouseMenu implements Menu {
    ArrayList menuItems;

    public PanCakeHouseMenu() {
        menuItems = new ArrayList();
        addItem("烤鸡","火烤的",false,22.5);
        addItem("水煮白菜","水煮的",true,8.5);
        addItem("干煸四季豆","热炒的",true,11.5);
        addItem("干拌面","烫熟的",false,5.5);
    }

    public void addItem(String name, String description, boolean vegetarion, double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarion,price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator(){
        return menuItems.iterator();
    }
}
