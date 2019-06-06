package com.cl.threadCore.chapter1;

public class PSuspendResumeStopLock extends  Thread{
    private long i=0;

    @Override
    public void run() {
        while (true){
            i++;
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        PSuspendResumeStopLock thread = new PSuspendResumeStopLock();
        thread.start();
        Thread.sleep(1000);
        thread.suspend();
        System.out.println("main end");
    }
    /**
     * println被暂停了 无法输出main end
     */
}
