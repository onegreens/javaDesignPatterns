package com.cl.pattern.state.newState;

/**
 * Created by cl on 2017/7/29.
 */
public class SoldOutState implements State {
    transient GumBallMachine gumBallMachine;

    public SoldOutState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void insertQuarter() {
        System.out.println("不好意思，卖完了");
        gumBallMachine.setState(gumBallMachine.getSoldOutState());

    }

    public void ejectQuarter() {
        System.out.println("没有钱可退");
        gumBallMachine.setState(gumBallMachine.getSoldOutState());

    }

    public void turnCrank() {
        System.out.println("没有投币，无法使用");
        gumBallMachine.setState(gumBallMachine.getSoldOutState());

    }

    public void dispense() {
        System.out.println("没有投币，无法发送糖果");
        gumBallMachine.setState(gumBallMachine.getSoldOutState());

    }
}
