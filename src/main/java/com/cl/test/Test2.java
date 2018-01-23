package com.cl.test;

import com.cl.javaNote.innerclasses.mian.Parcel3;

import java.util.Date;

/**
 * Created by cl on 2017/11/1.
 */
public class Test2 extends Test1 {

    private String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return super.toString() + "Test2{" +
                "age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        System.out.println("年: " + calendar.get(Calendar.YEAR));
//        System.out.println("月: " + (calendar.get(Calendar.MONTH) + 1) + "");
//        System.out.println("日: " + calendar.get(Calendar.DAY_OF_MONTH));
//        System.out.println("时: " + calendar.get(Calendar.HOUR_OF_DAY));
//        System.out.println("分: " + calendar.get(Calendar.MINUTE));
//        System.out.println("秒: " + calendar.get(Calendar.SECOND));
//        System.out.println("当前时间毫秒数：" + calendar.getTimeInMillis());
//        System.out.println(calendar.getTime());
        System.out.println(new Date().getYear() + 1900);
        System.out.println(new Date().getMonth() + 1);
    }
}
