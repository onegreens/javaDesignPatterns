package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2018/1/3.
 * 在Practice21的基础上，为enum写一个switch语句，
 * 对于每一个case。输出该特定货币的描述
 */
public class Practice22 {
    public static void main(String[] args) {
        new Practice22().hello(Coin.FIVE);
    }
    public void hello(Coin coin) {
        switch (coin) {
            case ONE:
                System.out.println("this is " + coin);break;
            case FIVE:
                System.out.println("this is " + coin);break;
            case TEN:
                System.out.println("this is " + coin);break;
            case MINUTE:
                System.out.println("this is " + coin);break;
            case HUNDRED:
                System.out.println("this is " + coin);break;
            default:
                System.out.println("over");
        }
    }
}
