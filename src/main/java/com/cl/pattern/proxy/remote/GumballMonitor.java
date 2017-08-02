package com.cl.pattern.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by cl on 2017/7/31.
 */
public class GumballMonitor {
    GumballMachineRemote gumballMachineRemote;

    public GumballMonitor(GumballMachineRemote gumballMachineRemote) {
        this.gumballMachineRemote = gumballMachineRemote;
    }

    public void report() {
        try {
            System.out.println("数量"+gumballMachineRemote.getCount());
            System.out.println("位置"+gumballMachineRemote.getLocation());
            System.out.println("状态"+gumballMachineRemote.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String location  = "rmi://localhost:8888/gumBallMachine";
        try {
            GumballMachineRemote gumballMachineRemote = (GumballMachineRemote) Naming.lookup(location);
            GumballMonitor gumballMonitor = new GumballMonitor(gumballMachineRemote);
            gumballMonitor.report();
            System.out.println("输出完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
