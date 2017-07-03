package com.cl.obersver.subject;

import com.cl.obersver.observer.Observer;

import java.util.ArrayList;


/**
 * Created by cl on 2017/6/17.
 * 天气数据
 */
public class WeathData implements Subject {

    private ArrayList observers;
    //温度
    private float temperature;
    //湿度
    private float humidity;
    //气压
    private float pressure;

    public WeathData() {
        observers = new ArrayList();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if (i >= 0) {
            observers.remove(observer);
        }
    }

    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
