package com.cl.test;

/**
 * Created by cl on 2017/12/21.
 */
public class Test6 implements Test5 {
    public Test6() {
    }

    public void say() {

    }

    public static void main(String[] args) {
        new Test6().test();
    }

    public void test() {
        int size_x = 20;
        int size_y = 20;
        int cen_x = 9;
        int cen_y = 9;
        int r = 8 ;
        for (int i = 0; i < size_x; i++) {
            System.out.print("        ");
            for (int j = 0; j < size_y; j++) {
                if (circle((i - cen_x), (j - cen_y), r))
                    System.out.print("1 ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    public long ride(long x) {
        return x * x;
    }

    public boolean circle(long x, long y, long r) {
        long circle = ride(x) + ride(y);
        long circle_r = ride(r);
        if (circle - circle_r < 10)
            if (circle_r - circle < 10)
                return true;
        return false;
    }
}
