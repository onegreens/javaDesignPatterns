/**
 * Created by cl on 2017/8/10.
 * 线程之间的协作
 *
 */
package com.cl.javaNote.threadNote.cooperation;

/*
    将线程挂起，直到某些条件发生变化，恢复执行

    wait() 将线程挂起，同时会释放持有锁，而sleep()和yield()并不会释放锁
    notify()、notifyAll()唤醒线程
    wait()只有通过调用上述两个方法或者命令时间到期才会恢复
    使用范围：同步控制方法、同步控制块
 */