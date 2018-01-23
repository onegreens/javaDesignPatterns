package com.cl.pattern.obersver.subject;

import java.util.Observable;


/**
 * Created by cl on 2017/6/17.
 * 天气数据
 */
public class WeatherData_java extends Observable {

    //温度
    private float temperature;
    //湿度
    private float humidity;
    //气压
    private float pressure;

    public WeatherData_java() {
    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
