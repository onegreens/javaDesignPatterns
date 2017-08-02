package com.cl.pattern.proxy;

import com.cl.pattern.state.newState.GumBallMachine;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by cl on 2017/7/31.
 */
public class Test {
    public static void main(String[] args) {
        GumBallMachine gumBallMachine = null;
        try {
            gumBallMachine = new GumBallMachine("localhost:8888/gumBallMachine",10);
            LocateRegistry.createRegistry(8888);
            Naming.rebind("rmi://localhost:8888/gumBallMachine",gumBallMachine);
            System.out.println("链接成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
