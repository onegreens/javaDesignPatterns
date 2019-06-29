package com.cl.threadCore.chapter1;

/**
 * Suspend Resume对同步数据的影响
 */
public class QSuspendResumeNoSameValue {
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

    synchronized void setValue(String username, String password) {
            this.username = username;
            if(Thread.currentThread().getName().equals("a")){
                System.out.println("a 线程暂停");
                Thread.currentThread().suspend();
            }
            this.password = password;



    }

    @Override
    public String toString() {
        return "QSuspendResumeNoSameValue{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }




    public static void main(String[] args) throws InterruptedException {
        final QSuspendResumeNoSameValue obj = new QSuspendResumeNoSameValue();
        Thread thread = new Thread(){
            @Override
            public void run() {
                obj.setValue("qwer","456");
            }
        };
        thread.setName("a");
        thread.start();
        Thread.sleep(500);
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                System.out.println(obj.toString());
            }
        };
        thread2.setName("b");
        thread2.start();
    }

}


