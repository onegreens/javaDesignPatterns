package com.cl.pattern.packaging.entity;

/**
 * Created by cl on 2017/7/12.
 */
public abstract class CaffeineBeverage {


    public final void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addcondiments();
        }
    }

    public void boilWater(){
        System.out.println("boiling water");
    }

    abstract void brew();

    public void pourInCup(){
        System.out.println("pouring into cup");
    }

    abstract void addcondiments();

    boolean customerWantsCondiments(){
        return true;
    }
}
