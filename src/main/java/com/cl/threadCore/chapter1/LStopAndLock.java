package com.cl.threadCore.chapter1;

/**
 * stop对数据的影响
 */
public class LStopAndLock {
    private String username = "abc";
    private String password = "123";

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    synchronized void printString(String username, String password) {
        try {
            this.username = username;
            Thread.sleep(1000);
            this.password = password;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "LStopAndLock{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    static class LThread extends Thread {
        private LStopAndLock obj;

        public LThread(LStopAndLock obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            obj.printString("qwer","456");
        }
    }


    public static void main(String[] args) throws InterruptedException {
        LStopAndLock obj = new LStopAndLock();
        LThread thread = new LThread(obj);
        thread.start();
        Thread.sleep(500);
        thread.stop();
        System.out.println(obj.toString());
    }

}


