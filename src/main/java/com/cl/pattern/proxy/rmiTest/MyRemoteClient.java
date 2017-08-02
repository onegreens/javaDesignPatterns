package com.cl.pattern.proxy.rmiTest;

import java.rmi.Naming;

/**
 * Created by cl on 2017/7/31.
 */
public class MyRemoteClient {

    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    void go(){
        try {
            MyRemote online = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = online.sayHello();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
