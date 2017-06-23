package com.cl.description.base;

/**
 * Created by cl on 2017/6/23.
 * 基础抽象类
 */
public abstract class Beverage {

    public String description = "nuknown beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
