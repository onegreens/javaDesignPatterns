package com.cl.dataAndArithmeticAnalyes.chapter10.dynamicProgramming;

/**
 * 斐波那契数
 */
public class Fib {
    /**
     *
     程序的运行时间T(N)满足T(N)>=T(N-1)+T(N-2).
     由于T(N)作为斐波那契数满足同样的地推关系并具有相同的初始条件,因此,T(N)事实上是以与斐波那契数相同的速度增长而是指数级
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n <= 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 由于计算Fn所需要的只是Fn-1和Fn-2,因此只需记录最近算出的量给斐波那契数.
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n < 1)
            return 1;
        int last = 1;
        int nextToLast = 1;
        int answer = 1;
        for (int i = 0; i <= n; i++) {
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }
}
