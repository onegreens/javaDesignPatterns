package com.cl.pattern.state.newState;


import java.util.Random;

/**
 * Created by cl on 2017/7/29.
 */
public class HasQuarterState implements State {

    Random winnerRandom = new Random(System.currentTimeMillis());
    transient GumBallMachine gumBallMachine;

    public HasQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void insertQuarter() {
        System.out.println("无法再次投入硬币");
    }

    public void ejectQuarter() {
        System.out.println("正在退钱");
        gumBallMachine.setState(gumBallMachine.getNoQuarterState());
    }

    public void turnCrank() {
        System.out.println("转动了，正在处理");
        int winnner = winnerRandom.nextInt(10);
        if (winnner == 0 && gumBallMachine.getCount() > 1) {
            gumBallMachine.setState(gumBallMachine.getWinnerState());

        } else {
            gumBallMachine.setState(gumBallMachine.getSoldState());
        }

    }

    public void dispense() {
        System.out.println("有糖果");
    }
}
