package com.cl.Obersver.subject;

import com.cl.Obersver.observer.Observer;

/**
 * Created by cl on 2017/6/17.
 * 主题接口
 */
public interface Subject {

    /**
     * 添加
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除
     * @param observer
     */
    void removeObserver(Observer observer);

    /**
     * 删除
     */
    void notifyObserver();


}
