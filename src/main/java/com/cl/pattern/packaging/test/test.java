package com.cl.pattern.packaging.test;

import com.cl.pattern.packaging.entity.CaffeineBeverage;
import com.cl.pattern.packaging.entity.Coffee;
import com.cl.pattern.packaging.entity.Tea;
import com.cl.pattern.packaging.sort.Duck;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by cl on 2017/7/12.
 */
public class test {
    public static void main1(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();
    }

    public static void main2(String[] args) {
        Coffee tea = new Coffee();
        tea.prepareRecipe();
    }

    public static void main(String[] args) {
        Duck[] ducks  = {
                new Duck("鸭子一号",12),
                new Duck("鸭子二号",133),
                new Duck("鸭子三号",53),
                new Duck("鸭子四号",23)
        };

        System.out.println("before sort:");
        display(ducks);

        Arrays.sort(ducks);

        System.out.println("after sort");
        display(ducks);
    }

    public static void display(Duck[] ducks) {
        for (int i = 0; i < ducks.length; i++) {
            Duck duck = ducks[i];
            System.out.println(duck.toString());
        }
    }
}
