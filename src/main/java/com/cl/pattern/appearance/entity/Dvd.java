package com.cl.pattern.appearance.entity;

/**
 * Created by cl on 2017/7/8.
 */
public class Dvd {
    String type;
    public void on() {
        System.out.println("打开了dvd");
    }

    public void play(String type) {
        this.type = type;
        System.out.println("播放==="+type);
    }

    public void stop() {
        System.out.println("停止了dvd");
    }

    public void off() {
        System.out.println("关闭了dvd");
    }
    public void eject() {
        System.out.println("退出dvd");
    }

}
