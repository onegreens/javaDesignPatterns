package com.cl.javaNote.execl;

public class Record {
    String category;
    String code_type;
    String city_code;
    String times;
    Double num;
    Double power;
    String total_type;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String getTotal_type() {
        return total_type;
    }

    public void setTotal_type(String total_type) {
        this.total_type = total_type;
    }

    @Override
    public String toString() {
        return category +
                '|' + code_type +
                '|' + city_code +
                "|'" + times +
                "|" + num +
                "|" + power +
                "|" + total_type;
    }
}
