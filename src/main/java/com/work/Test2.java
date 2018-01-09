package com.work;

import java.util.concurrent.ExecutionException;

/**
 * Created by cl on 2017/11/23.
 */
public class Test2 {
    public static void main1(String[] args) {
        try {
            throw new ExecutionException("", new Throwable());
        } catch (Exception e) {
            String exception = e.getClass().getName();
            System.out.println(exception);
            exception = e.getMessage();
            System.out.println(exception);
            exception = e.getClass().getSimpleName();
            System.out.println(exception);
        }
    }

    public static void main2(String[] args) {
        String str = "1111-22-11";
        if (str.matches("\\w\\w\\w\\w-\\w\\w-\\w\\w"))
            System.out.println("匹配");
    }

    public static void main(String[] args) {
        System.out.println(switchTest(2));
    }

    static Integer switchTest(Integer num) {
        switch (num) {
            case 1:
                System.out.println(1);
//                return 5;
            case 2:
                System.out.println(2);
//                return 10;
            case 3:
                System.out.println(3);
//                return 15;
        }
        return 0;
    }
}
