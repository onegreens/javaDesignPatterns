package com.cl.pattern.state.newState;

import com.cl.pattern.state.agent.GumBallMonitor;

import java.rmi.RemoteException;

/**
 * Created by cl on 2017/7/28.
 */
public class Test {

    public static void main1(String[] args) throws RemoteException {
        GumBallMachine gumBallMachine = new GumBallMachine("",5);
        System.out.println(gumBallMachine);

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.refill(5);
        System.out.println(gumBallMachine);
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);


    }

    public static void main(String[] args) throws RemoteException {
        int count = 0;

        if (args.length <2){
            System.out.println("不知道干嘛");
            System.exit(1);
        }

        count = Integer.parseInt(args[1]);

        GumBallMachine gumBallMachine = new GumBallMachine(args[0],count);

        GumBallMonitor gumBallMonitor = new GumBallMonitor(gumBallMachine);

        gumBallMonitor.report();
    }

}
