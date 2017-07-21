package com;

/**
 * Created by cl on 2017/7/19.
 */
public class ForTest {

    public static void main(String[] args) {
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
}
