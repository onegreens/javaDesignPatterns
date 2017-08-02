package com.cl.pattern.state.newState;


/**
 * Created by cl on 2017/7/29.
 */
public class NoQuarterState implements State {
    transient GumBallMachine gumBallMachine;

    public NoQuarterState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void insertQuarter() {
        System.out.println("你投入了一枚硬币");
        gumBallMachine.setState(gumBallMachine.getHasQuarterState());
    }

    public void ejectQuarter() {
        System.out.println("你还没给钱");
    }

    public void turnCrank() {
        System.out.println("转动了，但是没钱");

    }

    public void dispense() {
        System.out.println("你首先的付钱");
    }
}
