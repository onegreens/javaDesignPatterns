package com.cl.threadCore.chapter2.section2;

/**
 * 使用同步代码块
 */
public class SynOneThreadIn {
    public void serviceMethod() {
        try {
            synchronized (this) {
                System.out.println("begin time " + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time " + System.currentTimeMillis());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynOneThreadIn synOneThreadIn = new SynOneThreadIn();
        SOTIThread threadA = new SOTIThread(synOneThreadIn);
        threadA.start();
        SOTIThread threadB = new SOTIThread(synOneThreadIn);
        threadB.start();
    }
}

class SOTIThread extends Thread {
    SynOneThreadIn synOneThreadIn;

    public SOTIThread(SynOneThreadIn synOneThreadIn) {
        this.synOneThreadIn = synOneThreadIn;
    }

    @Override
    public void run() {
        synOneThreadIn.serviceMethod();
    }
}
