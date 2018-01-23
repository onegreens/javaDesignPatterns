package com.cl.interview.FileOperation.arithmetic;

/**
 * Created by cl on 2018/1/15.
 * 第1个人10，第2个比第1个人大2岁，依次递推，请用递归方式计算出第8个人多大？
 */
public class Test2 {
    void method(int age,int num){
        num--;
        System.out.println("第"+(8-num)+"个人，"+age+"岁");
        age +=2;
        if (num>0)
            method(age,num);
    }

    public static void main(String[] args) {
        new Test2().method(10,8);
    }
}
