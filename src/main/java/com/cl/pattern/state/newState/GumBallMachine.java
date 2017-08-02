package com.cl.pattern.state.newState;

import com.cl.pattern.proxy.remote.GumballMachineRemote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by cl on 2017/7/28.
 */
public class GumBallMachine extends UnicastRemoteObject implements GumballMachineRemote{

    State soldState;
    State hasQuarterState;
    State noQuarterState;
    State soldOutState;
    State winnerState;
    String location;

    State state = soldOutState;
    int count = 0;

    public GumBallMachine(String location,int numberGumballs) throws RemoteException {
        soldOutState = new SoldOutState(this);
        soldState = new SoldState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        this.location = location;
        if (count>0){
            state =noQuarterState;
        }
    }

    public State getState() {
        return state;
    }

    void refill(int numberGumballs){
        System.out.println("重新填装了糖果");
        this.count += numberGumballs;
        if (count>0){
            state =noQuarterState;
        }
    }

    public String getLocation() {
        return location;
    }

    /**
     * 投入硬币
     */
    void insertQuarter(){
        state.insertQuarter();
    }

    /**
     * 退出硬币
     */
    void ejectQuarter(){
        state.ejectQuarter();
    }

    /**
     * 转动手柄
     */
    void turnCrank(){
        state.turnCrank();
        state.dispense();
    }


    void setState(State state){
        this.state = state;
    }

    void releaseBall(){
        System.out.println("卖出了一个糖果");
        if (count != 0){
            count --;
        }
    }

    public State getSoldState() {
        return soldState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "GumBallMachine{" +
                ", state=" + state +
                ", count=" + count +
                '}';
    }
}
