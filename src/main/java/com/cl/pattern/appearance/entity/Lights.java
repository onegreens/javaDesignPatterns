package com.cl.pattern.appearance.entity;

/**
 * Created by cl on 2017/7/8.
 */
public class Lights {
    Integer dim;

    public void dim(Integer dim) {
        this.dim = dim;
        System.out.println("亮度调节为" + dim);
    }

    public void on() {
        dim = 0;
        System.out.println("打开了灯");
    }

    public Integer getDim() {
        return dim;
    }
}
