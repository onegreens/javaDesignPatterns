package com.cl.pattern.command.entity;

/**
 * Created by cl on 2017/7/3.
 */
public class Stereo {
    private Integer volume;

    public void setVolume(Integer volume) {
        this.volume = volume;
        System.out.println("设置音量为"+volume);
    }

    public void on(){
        System.out.println("打开了音响");
    }

    public void off(){
        System.out.println("关闭了音响");
    }

    public void setCd(){
        System.out.println("设置为cd播放");
    }
}
