package com.cl.pattern.command.control;

import com.cl.pattern.command.com.Command;

/**
 * Created by cl on 2017/6/30.
 * 控制器
 */
public class SimpleRemoteControl {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public SimpleRemoteControl() {
    }

    public void buttonWasPressed(){
        command.excute();
    }
}
