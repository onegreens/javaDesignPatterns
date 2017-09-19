package com.cl.dataStructures.recursion;

/**
 * Created by cl on 2017/9/14.
 * 汉诺塔
 */
public class Tower {
    static int nDisks = 3;
    static int num = 0;

    public static void doTowers(int topN, char form, char inter, char to) {
        System.out.println(topN+" "+form+" "+inter+" "+to+" "+num++);
        if (topN == 1)
            System.out.println("disk 1 from " + form + " to " + to);
        else {
            doTowers(topN - 1, form, to, inter);
            System.out.println("disk " + topN + " from " + form + " to " + to);
            doTowers(topN - 1, inter, form, to);

        }
    }

    public static void main(String[] args) {
        doTowers(nDisks,'A','B','C');
    }
}
