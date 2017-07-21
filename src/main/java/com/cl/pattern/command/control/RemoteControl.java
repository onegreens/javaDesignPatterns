package com.cl.pattern.command.control;

import com.cl.pattern.command.com.Command;
import com.cl.pattern.command.com.NoCommand;

import java.util.Arrays;

/**
 * Created by cl on 2017/7/3.
 * 遥控指令
 */
public class RemoteControl {
    //创建需要的指令
    Command[] onCommands;
    Command[] offCommands;
    Command unCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        //避免空指令，所以先添加指令
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        unCommand = noCommand;
    }

    //为指令赋值
    public void setCommand(int salt, Command onCommand,Command offCommand){
        onCommands[salt] = onCommand;
        offCommands[salt] = offCommand;
    }

    //执行对应的指令
    public void onButtonWasPushed(int salt){
        onCommands[salt].excute();
        unCommand = onCommands[salt];
    }

    public void offButtonWasPushed(int salt){
        offCommands[salt].excute();
        unCommand = offCommands[salt];

    }

    public void undoButtonWasPush(){
        unCommand.undo();

    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
