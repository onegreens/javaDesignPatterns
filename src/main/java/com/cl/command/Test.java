package com.cl.command;

import com.cl.command.com.GaragerDoorOnCommand;
import com.cl.command.com.LightOnCommand;
import com.cl.command.control.SimpleRemoteControl;
import com.cl.command.entity.GarageDoor;
import com.cl.command.entity.Light;

/**
 * Created by cl on 2017/6/30.
 */
public class Test {

    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        LightOnCommand lightOnCommand = new LightOnCommand(new Light());
        GaragerDoorOnCommand garagerDoorOnCommand = new GaragerDoorOnCommand(new GarageDoor());
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
        simpleRemoteControl.setCommand(garagerDoorOnCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}
