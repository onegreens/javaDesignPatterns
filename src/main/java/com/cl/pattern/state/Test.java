package com.cl.pattern.state;

/**
 * Created by cl on 2017/7/28.
 */
public class Test {

    public static void main1(String[] args) {
        GumBallMachine gumBallMachine = new GumBallMachine(5);
        System.out.println(gumBallMachine);

        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);

        gumBallMachine.insertQuarter();
        gumBallMachine.ejectQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);

        gumBallMachine.insertQuarter();
        gumBallMachine.ejectQuarter();
        gumBallMachine.insertQuarter();
        gumBallMachine.ejectQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);

        gumBallMachine.insertQuarter();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        gumBallMachine.insertQuarter();
        gumBallMachine.turnCrank();
        System.out.println(gumBallMachine);


    }

    public static void main(String[] args) {
        GumBallMachine gumBallMachine = new GumBallMachine(5);

    }
}
