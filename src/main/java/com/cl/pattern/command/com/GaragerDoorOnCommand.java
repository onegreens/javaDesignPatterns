package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.GarageDoor;

/**
 * Created by cl on 2017/6/30.
 * 灯-命令
 */
public class GaragerDoorOnCommand implements Command {

    GarageDoor garageDoor;

    public GaragerDoorOnCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void excute() {
        garageDoor.on();
    }

    public void undo() {
        garageDoor.off();
    }
}
