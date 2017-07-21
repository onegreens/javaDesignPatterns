package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.Light;

/**
 * Created by cl on 2017/6/30.
 * 灯-命令
 */
public class LightOffCommand implements Command {

    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void excute() {
        light.off();
    }

    public void undo() {
        light.on();
    }
}
