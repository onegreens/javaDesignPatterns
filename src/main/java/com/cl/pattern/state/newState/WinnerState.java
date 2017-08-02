package com.cl.pattern.state.newState;


/**
 * Created by cl on 2017/7/29.
 */
public class WinnerState implements State {
    transient GumBallMachine gumBallMachine;

    public WinnerState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void insertQuarter() {
        System.out.println("无法再次投入硬币");
    }

    public void ejectQuarter() {
        System.out.println("错误：无法退钱");
    }

    public void turnCrank() {
        System.out.println("错误，无法摇动");
    }

    public void dispense() {
        System.out.println("你真幸运。获取两个糖果");
        gumBallMachine.releaseBall();
        if (gumBallMachine.getCount() == 0) {
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        } else {
            gumBallMachine.releaseBall();
            if (gumBallMachine.getCount() > 0) {
                gumBallMachine.setState(gumBallMachine.getNoQuarterState());
            } else {
                System.out.println("不好意思，卖完了");
                gumBallMachine.setState(gumBallMachine.getSoldOutState());
            }
        }
    }
}
