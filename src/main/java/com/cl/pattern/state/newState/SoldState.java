package com.cl.pattern.state.newState;

/**
 * Created by cl on 2017/7/29.
 */
public class SoldState implements State {
    transient GumBallMachine gumBallMachine;

    public SoldState(GumBallMachine gumBallMachine) {
        this.gumBallMachine = gumBallMachine;
    }

    public void insertQuarter() {
        System.out.println("无法再次投入硬币，正在处理，接收糖果");
    }

    public void ejectQuarter() {
        System.out.println("无法退钱，正在发放糖果");
    }

    public void turnCrank() {
        System.out.println("无效转动，正在发放糖果");
    }

    public void dispense() {
        System.out.println("正在派送");
        gumBallMachine.releaseBall();
        if(gumBallMachine.getCount()>0){
            gumBallMachine.setState(gumBallMachine.getNoQuarterState());
        }else {
            System.out.println("不好意思，卖完了");
            gumBallMachine.setState(gumBallMachine.getSoldOutState());
        }
    }
}
