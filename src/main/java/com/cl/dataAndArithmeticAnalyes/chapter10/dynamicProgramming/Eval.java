package com.cl.dataAndArithmeticAnalyes.chapter10.dynamicProgramming;

public class Eval {

    public static double eval(int n) {
        if (n == 0) return 1.0D;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += eval(i);
        }
        return 2 * sum / n + n;
    }

    /**
     * 简化
     * 使用一个表来计算值
     * @param n
     * @return
     */
    public static double evalSimplify(int n) {
        double[] d = new double[n + 1];
        d[0] = 1.0D;
        for (int i = 1; i <= n; i++) {
            double sum = 0;
            for (int j = 0; j < j; j++) {
                sum += d[j];
            }
            d[i] = 2 * sum / i + i;
        }
        return d[n];
    }
}
