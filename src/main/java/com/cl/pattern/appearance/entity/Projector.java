package com.cl.pattern.appearance.entity;

/**
 * Created by cl on 2017/7/8.
 */
public class Projector {

    String input;
    public void on(){
        System.out.println("打开投影仪");
    }

    public void setInput(String input){
        this.input = input;
        System.out.println("设置模式为"+input);
    }

    public void wideScreenMode(){
        System.out.println("设置宽屏");
    }

    public String getInput() {
        return input;
    }

    public void off(){
        input = null;
        System.out.println("关闭了投影仪");
    }


}
