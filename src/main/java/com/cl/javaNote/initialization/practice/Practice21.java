package com.cl.javaNote.initialization.practice;

/**
 * Created by cl on 2018/1/3.
 * 创建一个enum，它包含纸币中最小面值的6种类型
 * 通过value()循环并打印每一个值及其ordinal()
 */
public class Practice21 {
    public static void main(String[] args) {
        for(Coin coin : Coin.values())
            System.out.println(coin);

    }
}
enum Coin{
    MINUTE,ONE,FIVE,TEN,HUNDRED;
}
