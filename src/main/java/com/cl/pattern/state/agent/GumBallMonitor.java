package com.cl.pattern.state.agent;


import com.cl.pattern.state.newState.GumBallMachine;

/**
 * Created by cl on 2017/7/29.
 */
public class GumBallMonitor {
   GumBallMachine gumBallMachine;

    public GumBallMonitor(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void report(){
        System.out.println(gumBallMachine.getCount()+"个糖果");
        System.out.println("现在在"+gumBallMachine.getLocation());
        System.out.println("状态："+gumBallMachine.getState());
    }
}
