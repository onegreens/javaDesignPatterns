package com.cl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * Created by cl on 2017/10/20.
 */
public class DcSpTimer {
    public static boolean isRun = false;
    public static Timer timer = new Timer();

    private String result="zhuliang";

    public void start(){
        List messages = new ArrayList();

        if(!isRun){
            System.out.println("任务开始");
            isRun = true;
            timer = new Timer();
            timer.schedule(new DcSpTimerTask(), 1000, 2000);//在1秒后执行此任务,每次间隔2秒,如果传递一个Data参数,就可以在某个固定的时间执行这个任务.
        }
    }

    class DcSpTimerTask extends java.util.TimerTask{

        @Override
        public void run(){
            // TODO Auto-generated method stub
            System.out.println("________"+result);

        }
    }
}
