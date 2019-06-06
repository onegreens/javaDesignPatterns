package com.cl.threadCore.chapter2.section1;

/**
 * 可重入锁在继承中的应用
 */
public class SynLockInExtends extends Thread{
    @Override
    public void run() {
        SLIESub slieSub = new SLIESub();
        slieSub.operateSubMethod();
    }

    public static void main(String[] args) {
        SynLockInExtends thread = new SynLockInExtends();
        thread.start();
        /**
         SLIESub i : 10
         SLIEMain i : 9
         SLIESub i : 8
         SLIEMain i : 7
         SLIESub i : 6
         SLIEMain i : 5
         SLIESub i : 4
         SLIEMain i : 3
         SLIESub i : 2
         SLIEMain i : 1
         */
    }
}

class SLIEMain {
    public int i = 10;

    public synchronized void operateMainMethod() {
        try {
            System.out.println("SLIEMain i : " + i);
            i--;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SLIESub extends SLIEMain {
    public synchronized void operateSubMethod() {
        try {
            while (i>0){
                System.out.println("SLIESub i : " + i);
                i--;
                Thread.sleep(100);
                operateMainMethod();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
