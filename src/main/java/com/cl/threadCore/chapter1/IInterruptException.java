package com.cl.threadCore.chapter1;

/**
 * 测试 isInterrupted
 */
public class IInterruptException extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 50000000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("线程停止了,退出");
                    throw new InterruptedException();

                }
                if (i % 10000 == 0)
                    System.out.println("count = " + i);
            }
            System.out.println("只是for停止了而已");
        } catch (InterruptedException e) {
            System.out.println("捕捉到 run 输出的异常了");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            IInterruptException thread = new IInterruptException();
            thread.start();
            Thread.sleep(100);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("捕捉到 main 输出的异常了");
            e.printStackTrace();
        }
    }

}
