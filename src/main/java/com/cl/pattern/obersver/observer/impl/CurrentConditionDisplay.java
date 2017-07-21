package com.cl.pattern.obersver.observer.impl;

import com.cl.pattern.obersver.observer.DisplayElment;
import com.cl.pattern.obersver.observer.Observer;
import com.cl.pattern.obersver.subject.Subject;
import com.cl.pattern.obersver.subject.WeathData;

/**
 * Created by cl on 2017/6/17.
 * 布告板
 */
public class CurrentConditionDisplay implements DisplayElment,Observer {
    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        System.out.println("current condition : temperature : "+temperature + "and humidity : " + humidity);

    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();

    }


    public static void main(String[] args){
        WeathData weathData =new WeathData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weathData);
        weathData.setMeasurements(11,22,33);
        weathData.setMeasurements(12,34,45);
        weathData.setMeasurements(51,123,234);

    }
}
