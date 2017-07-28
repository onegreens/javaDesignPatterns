package com.cl.pattern.iterator.entity;

import com.cl.pattern.iterator.iter.impl.DinnerMenuIterator;

import java.util.Iterator;

/**
 * Created by cl on 2017/7/21.
 */
public class DinnerMenu implements Menu{
    final static int Max_Items = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinnerMenu() {
        menuItems = new MenuItem[Max_Items];
        addItem("包子","肉馅",false,1.2);
        addItem("粽子","肉馅",false,2.2);
        addItem("馒头","肉馅",true,3.2);
        addItem("米粥","肉馅",false,1.1);
        addItem("炒面","肉馅",true,1.4);
        addItem("饺子","肉馅",false,4.2);
        addItem("肠粉","肉馅",false,5.2);
    }

    public void addItem(String name, String description, boolean vegetarion, double price){
        MenuItem menuItem = new MenuItem(name,description,vegetarion,price);
        if (numberOfItems >= Max_Items){
            System.out.println("菜单已满");
        }else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems++;
        }
    }

    public Iterator createIterator(){
        return new DinnerMenuIterator(menuItems);
    }
}
