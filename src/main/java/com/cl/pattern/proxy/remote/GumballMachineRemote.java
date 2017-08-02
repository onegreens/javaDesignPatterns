package com.cl.pattern.proxy.remote;

import com.cl.pattern.state.newState.State;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by cl on 2017/7/31.
 */
public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;
    public String getLocation() throws RemoteException;
    public State getState() throws RemoteException;
}
