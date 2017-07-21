package com.cl.pattern.appearance.entity;

/**
 * Created by cl on 2017/7/8.
 */
public class Amp {
    Integer volume;
    public void on() {
        System.out.println("打开了功效");
    }

    public void setDvd(String type){
        System.out.println("设置模式为"+type);
    }

    public void setSurroundSound(){
        System.out.println("设置环绕立体");
    }

    public void setVolume(Integer volume){
        this.volume = volume;
        System.out.println("设置音量为"+volume);
    }

    public void off(){
        volume = 0;
        System.out.println("关闭了功效");
    }

}
