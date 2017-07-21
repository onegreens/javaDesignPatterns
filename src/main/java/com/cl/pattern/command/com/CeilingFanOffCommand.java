package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.CeilingFan;

/**
 * Created by cl on 2017/7/3.
 */
public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;
    int preSpend;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void excute() {
        ceilingFan.off();
    }

    public void undo() {
        ceilingFan.high();
    }
}
