package com.cl.pattern.proxy.rmiTest;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by cl on 2017/7/31.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    protected MyRemoteImpl() throws RemoteException {
    }

    public String sayHello() throws RemoteException {
        return "Server say : 'hey'";
    }

    public static void main(String[] args) {
        try {
            MyRemote myRemote = new MyRemoteImpl();
            Naming.rebind("RemoteHello",myRemote);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
