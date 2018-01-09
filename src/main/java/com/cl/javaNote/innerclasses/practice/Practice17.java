package com.cl.javaNote.innerclasses.practice;

import java.util.Random;

/**
 * Created by cl on 2018/1/5.
 * 使用工厂方法创建一个框架，它可以执行抛硬币和掷骰子功能
 */
public class Practice17 {
    static Random random = new Random();
    public static void flipCoin() {
        int i = random.nextInt(2);
        Coin coin;
        if (i == 1){
            coin = Coin1.coinFactory.getCoin();
        }else {
            coin = Coin2.coinFactory.getCoin();
        }
        coin.getFace();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            flipCoin();
        }
    }
}
interface Coin{
    void getFace();
}
interface CoinFactory{
    Coin getCoin();
}
class Coin1 implements Coin{
    public void getFace() {
        System.out.println("front");
    }
    static protected CoinFactory coinFactory = new CoinFactory() {
        public Coin getCoin() {
            return new Coin1();
        }
    };
}class Coin2 implements Coin{
    public void getFace() {
        System.out.println("verso");
    }
    static protected CoinFactory coinFactory = new CoinFactory() {
        public Coin getCoin() {
            return new Coin2();
        }
    };
}