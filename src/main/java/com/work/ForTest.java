package com.work;

/**
 * Created by cl on 2017/7/19.
 */
public class ForTest {

    public static void main1(String[] args) {
        loop:
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 5; i++) {
                System.out.println("当前数字：" + i);
                if (i == 3) {
                    System.out.println("i equal 3");
                    break loop;
                }
            }
        }
    }

    public static void main2(String[] args) {
        float i = 3;
        float j = 7;
        float s = i/j;
        System.out.println(s);

    }

    public static void main3(String[] args) {
        String phone = "13419642400";
        StringBuffer nes = new StringBuffer();
        nes.append(phone.substring(0,3)).append("****").append(phone.substring(phone.length()- 4));
        System.out.println(nes);
    }

    public static void main(String[] args) {
        String phone = "1341**2400";
        if (phone.contains("*")){
            System.out.println("ssssssssssssss");
        }
    }
}
