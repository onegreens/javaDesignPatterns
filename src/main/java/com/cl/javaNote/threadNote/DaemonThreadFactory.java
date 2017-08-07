package com.cl.javaNote.threadNote;

import java.util.concurrent.ThreadFactory;

/**
 * Created by cl on 2017/8/7.
 * 简单工厂之设置为后台线程
 */
public class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread d = new Thread(r);
        d.setDaemon(true);
        return d;

    }
}
