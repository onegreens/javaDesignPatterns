package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.CeilingFan;

/**
 * Created by cl on 2017/7/3.
 */
public class CeilingFanCommand implements Command {
    CeilingFan ceilingFan;
    int preSpend;

    public CeilingFanCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void excute() {
        preSpend = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    public void undo() {
        if (preSpend == ceilingFan.HIGH) {
            ceilingFan.high();
        } else if (preSpend == ceilingFan.MEDIUN) {
            ceilingFan.medium();
        } else if (preSpend == ceilingFan.LOW) {
            ceilingFan.low();
        }else if(preSpend == ceilingFan.OFF){
            ceilingFan.off();
        }
    }
}
