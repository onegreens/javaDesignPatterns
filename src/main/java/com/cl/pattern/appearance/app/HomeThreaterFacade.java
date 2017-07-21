package com.cl.pattern.appearance.app;

import com.cl.pattern.appearance.entity.*;

/**
 * Created by cl on 2017/7/8.
 */
public class HomeThreaterFacade {
    Amp amp;
    Dvd dvd;
    Lights lights;
    Popper popper;
    Projector projector;
    Screen screen;

    public HomeThreaterFacade(Amp amp, Dvd dvd, Lights lights, Popper popper, Projector projector, Screen screen) {
        this.amp = amp;
        this.dvd = dvd;
        this.lights = lights;
        this.popper = popper;
        this.projector = projector;
        this.screen = screen;
    }

    public void watchMovie() {
        System.out.println("准备开始看电影");
        popper.on();
        popper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        amp.on();
        amp.setDvd("dvd");
        amp.setSurroundSound();
        amp.setVolume(20);

        dvd.on();
        dvd.play("movie");
    }

    public void endMovie(){
        System.out.println("关闭了电影");

        popper.off();

        lights.on();

        screen.up();

        projector.off();

        amp.off();

        dvd.stop();
        dvd.eject();
        dvd.off();
    }




}
