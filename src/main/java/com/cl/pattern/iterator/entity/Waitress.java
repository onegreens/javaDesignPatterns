package com.cl.pattern.iterator.entity;


import java.util.Iterator;

/**
 * Created by cl on 2017/7/22.
 */
public class Waitress {
    Menu panCakeHouseMenu;
    Menu dinnerMenu;

    public Waitress(Menu panCakeHouseMenu, Menu dinnerMenu) {
        this.panCakeHouseMenu = panCakeHouseMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu(){
        Iterator panMenu = panCakeHouseMenu.createIterator();
        System.out.println("pancake的菜单");
        printMenu(panMenu);

        Iterator dinner = dinnerMenu.createIterator();
        System.out.println("dinner的菜单");
        printMenu(dinner);

    }

    public void printMenu(Iterator iterator){
        while(iterator.hasNext()){
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.getDescription());
        }
    }
}
