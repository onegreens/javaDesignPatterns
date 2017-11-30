package com.cl.pattern.obersver.subject;

import com.cl.pattern.obersver.observer.Observer;

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
     * 通知
     */
    void notifyObserver();


}
