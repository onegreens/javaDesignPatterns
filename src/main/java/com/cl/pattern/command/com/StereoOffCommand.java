package com.cl.pattern.command.com;

import com.cl.pattern.command.entity.Stereo;

/**
 * Created by cl on 2017/7/3.
 */
public class StereoOffCommand implements Command{

    Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }


    public void excute() {
        stereo.off();
    }

    public void undo() {
        stereo.on();
    }
}
