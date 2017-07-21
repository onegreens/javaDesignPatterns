package com.cl.pattern.command.com;

/**
 * Created by cl on 2017/6/30.
 * 命令
 */
public interface Command {

    //执行对应的方法
    public void excute();

    public void undo();
}
