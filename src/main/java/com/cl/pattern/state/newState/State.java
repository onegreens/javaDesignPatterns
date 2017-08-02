package com.cl.pattern.state.newState;

import java.io.Serializable;

/**
 * Created by cl on 2017/7/29.
 */
public interface State extends Serializable {

    /**
     * 投入硬币
     */
    void insertQuarter();

    /**
     * 退出硬币
     */
    void ejectQuarter();

    /**
     * 转动手柄
     */
    void turnCrank();

    /**
     * 发送糖果
     */
    void dispense();
}
