package com.cl.pattern.proxy.rmiTest;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cl on 2017/7/31.
 */
public interface MyRemote extends Remote{
    public String sayHello()throws RemoteException;
}
