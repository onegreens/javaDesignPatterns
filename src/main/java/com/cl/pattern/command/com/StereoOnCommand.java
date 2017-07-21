package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.Stereo;

/**
 * Created by cl on 2017/7/3.
 */
public class StereoOnCommand implements Command{

    Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }


    public void excute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume(11);
    }

    public void undo() {
        stereo.off();
    }
}
