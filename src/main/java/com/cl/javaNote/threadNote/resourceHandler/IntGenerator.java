package com.cl.javaNote.threadNote.resourceHandler;

/**
 * Created by cl on 2017/8/8.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
