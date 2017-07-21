package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.Light;

/**
 * Created by cl on 2017/6/30.
 * 灯-命令
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void excute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
