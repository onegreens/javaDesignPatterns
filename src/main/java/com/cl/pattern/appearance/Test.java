package com.cl.pattern.appearance;

import com.cl.pattern.appearance.app.HomeThreaterFacade;
import com.cl.pattern.appearance.entity.*;

/**
 * Created by cl on 2017/7/8.
 */
public class Test {
    public static void main(String[] args) {
        Amp amp = new Amp();
        Dvd dvd = new Dvd();
        Lights lights = new Lights();
        Popper popper = new Popper();
        Projector projector = new Projector();
        Screen screen = new Screen();

        HomeThreaterFacade homeThreaterFacade = new HomeThreaterFacade(amp, dvd, lights, popper, projector, screen);
        homeThreaterFacade.watchMovie();
        System.out.println("=====================");
        homeThreaterFacade.endMovie();

    }


}
