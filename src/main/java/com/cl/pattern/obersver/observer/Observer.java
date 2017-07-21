package com.cl.pattern.obersver.observer;

/**
 * Created by cl on 2017/6/17.
 * 观察
 */
public interface Observer {
    /**
     * 更新
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp,float humidity,float pressure);
}
