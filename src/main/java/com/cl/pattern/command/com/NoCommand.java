package com.cl.pattern.command.com;

/**
 * Created by cl on 2017/7/3.
 */
public class NoCommand implements Command {
    public void excute() {
        System.out.println("这是一条指令");
    }

    public void undo() {
        System.out.println("这是一条撤销指令");
    }
}
