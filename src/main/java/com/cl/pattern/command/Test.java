package com.cl.pattern.command;

import com.cl.pattern.command.com.*;
import com.cl.pattern.command.control.RemoteControl;
import com.cl.pattern.command.control.SimpleRemoteControl;
import com.cl.pattern.command.entity.CeilingFan;
import com.cl.pattern.command.entity.GarageDoor;
import com.cl.pattern.command.entity.Light;
import com.cl.pattern.command.entity.Stereo;

/**
 * Created by cl on 2017/6/30.
 */
public class Test {

    public static void main1(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        LightOnCommand lightOnCommand = new LightOnCommand(new Light());
        GaragerDoorOnCommand garagerDoorOnCommand = new GaragerDoorOnCommand(new GarageDoor());
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
        simpleRemoteControl.setCommand(garagerDoorOnCommand);
        simpleRemoteControl.buttonWasPressed();
    }

    public static void main2(String[] args) {
        //实例化控制器
        RemoteControl remoteControl = new RemoteControl();

        //实例化实体类
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        //实例化命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        GaragerDoorOnCommand garagerDoorOnCommand = new GaragerDoorOnCommand(garageDoor);
        GaragerDoorOffCommand garagerDoorOffCommand= new GaragerDoorOffCommand(garageDoor);
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        //将命令添加到控制器中
        remoteControl.setCommand(0,stereoOnCommand,stereoOffCommand);
        remoteControl.setCommand(1,garagerDoorOnCommand,garagerDoorOffCommand);
        remoteControl.setCommand(2,lightOnCommand,lightOffCommand);

        //执行相应的命令
        remoteControl.onButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(0);
        remoteControl.offButtonWasPushed(1);
        remoteControl.offButtonWasPushed(2);
        remoteControl.undoButtonWasPush();
        remoteControl.toString();
    }

    public static void main3(String[] args) {
        //实例化控制器
        RemoteControl remoteControl = new RemoteControl();

        CeilingFan ceilingFan = new CeilingFan("Living room");

        CeilingFanCommand ceilingFanCommand = new CeilingFanCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

        remoteControl.setCommand(1,ceilingFanCommand,ceilingFanOffCommand);

        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        remoteControl.undoButtonWasPush();
    }

    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        //实例化实体类
        Light light = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        //实例化命令
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        GaragerDoorOnCommand garagerDoorOnCommand = new GaragerDoorOnCommand(garageDoor);
        GaragerDoorOffCommand garagerDoorOffCommand= new GaragerDoorOffCommand(garageDoor);
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);

        Command[] commands = {lightOnCommand,garagerDoorOnCommand,stereoOnCommand};
        Command[] commandsoff = {lightOffCommand,garagerDoorOffCommand,stereoOffCommand};
        MacroCommand macroCommand = new MacroCommand(commands);
        MacroOffCommand macroCommandoFF = new MacroOffCommand(commandsoff);

        remoteControl.setCommand(0,macroCommand,macroCommandoFF);

        remoteControl.onButtonWasPushed(0);
//        remoteControl.offButtonWasPushed(0);
        remoteControl.undoButtonWasPush();

    }
}
