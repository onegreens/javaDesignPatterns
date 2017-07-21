package com.cl.pattern.command.com;

/**
 * Created by cl on 2017/7/3.
 */
public class MacroOffCommand implements Command {
    Command[] commands;

    public MacroOffCommand(Command[] commands) {
        this.commands = commands;
    }

    public void excute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].excute();
        }
    }

    public void undo() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].undo();
        }
    }
}
