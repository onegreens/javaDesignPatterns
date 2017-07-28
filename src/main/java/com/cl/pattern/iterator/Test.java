package com.cl.pattern.iterator;

import com.cl.pattern.iterator.component.*;
import com.cl.pattern.iterator.component.Menu;
import com.cl.pattern.iterator.entity.*;
import com.cl.pattern.iterator.entity.MenuItem;
import com.cl.pattern.iterator.entity.Waitress;

import java.util.ArrayList;

/**
 * Created by cl on 2017/7/22.
 */
public class Test {
    public static void main1(String[] args) {
        PanCakeHouseMenuOld panCakeHouseMenu = new PanCakeHouseMenuOld();
        ArrayList menuItemList = panCakeHouseMenu.getMenuItems();

        DinnerMenuOld dinnerMenu = new DinnerMenuOld();
        MenuItem[] menuItems = dinnerMenu.getMenuItems();

        for (int i = 0; i < menuItemList.size(); i++) {
            MenuItem menuItem = (MenuItem) menuItemList.get(i);
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.getDescription());
        }

        for (int i = 0; i < menuItems.length; i++) {
            MenuItem menuItem = menuItems[i];
            System.out.println(menuItem.getName());
            System.out.println(menuItem.getPrice());
            System.out.println(menuItem.getDescription());
        }

    }

    public static void main2(String[] args) {
        PanCakeHouseMenu panCakeHouseMenu = new PanCakeHouseMenu();
        DinnerMenu dinnerMenu = new DinnerMenu();

        Waitress waitress = new Waitress(panCakeHouseMenu, dinnerMenu);
        waitress.printMenu();
    }

    public static void main3(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancake", "beackfast");
        MenuComponent dinnerMenu = new Menu("dinnerMenu", "lunch");
        MenuComponent cafeMenu = new Menu("cafeMenu", "dinner");
        MenuComponent deeesertMenu = new Menu("cafeMenu", "dinner");

        MenuComponent menuAll = new Menu("all  menus", "all menus combined");
        menuAll.add(pancakeHouseMenu);
        menuAll.add(cafeMenu);
        menuAll.add(dinnerMenu);

        dinnerMenu.add(new com.cl.pattern.iterator.component.MenuItem("烤鸡", 22.5, "火烤的", false));
        dinnerMenu.add(deeesertMenu);
        deeesertMenu.add(new com.cl.pattern.iterator.component.MenuItem("111烤鸡", 22.5, "火烤的", false));
        com.cl.pattern.iterator.component.Waitress waitress = new com.cl.pattern.iterator.component.Waitress(menuAll);
        waitress.print();
    }

    public static void main(String[] args) {
        MenuComponent pancakeHouseMenu = new Menu("pancake", "beackfast");
        MenuComponent dinnerMenu = new Menu("dinnerMenu", "lunch");
        MenuComponent cafeMenu = new Menu("cafeMenu", "dinner");
        MenuComponent deeesertMenu = new Menu("cafeMenu", "dinner");

        MenuComponent menuAll = new Menu("all  menus", "all menus combined");
        menuAll.add(pancakeHouseMenu);
        menuAll.add(cafeMenu);
        menuAll.add(dinnerMenu);

        dinnerMenu.add(new com.cl.pattern.iterator.component.MenuItem("烤鸡", 22.5, "火烤的", true));
        dinnerMenu.add(deeesertMenu);
        deeesertMenu.add(new com.cl.pattern.iterator.component.MenuItem("111烤鸡", 22.5, "火烤的", false));
        com.cl.pattern.iterator.component.Waitress waitress = new com.cl.pattern.iterator.component.Waitress(menuAll);
        waitress.printVetegetarainMenu();
    }


}
