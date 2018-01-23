package com.cl.pattern.obersver.observer.impl;

import com.cl.pattern.obersver.observer.DisplayElment;
import com.cl.pattern.obersver.subject.Subject;
import com.cl.pattern.obersver.subject.WeatherData_java;

import java.util.Observable;

/**
 * Created by cl on 2017/6/17.
 * 布告板
 */
public class CurrentConditionDisplay_java implements DisplayElment, java.util.Observer {
    Observable observable;

    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionDisplay_java(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void display() {
        System.out.println("current condition : temperature : " + temperature + "and humidity : " + humidity);

    }

    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData_java) {
            WeatherData_java weathData_java = (WeatherData_java) o;
            this.temperature = weathData_java.getTemperature();
            this.humidity = weathData_java.getHumidity();
            display();
        }
    }

    public static void main(String[] args) {
        WeatherData_java weathData = new WeatherData_java();
        CurrentConditionDisplay_java currentConditionDisplay = new CurrentConditionDisplay_java(weathData);
        weathData.setMeasurements(1661, 22, 33);
        weathData.setMeasurements(12, 34, 45);
        weathData.setMeasurements(51, 123, 234);

    }


}
