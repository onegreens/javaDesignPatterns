package com.cl.javaNote.generics.generator;

/**
 * Created by cl on 2017/12/16.
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;
    public Integer next() {
        return fib(count++);
    }
    public int fib(int n){
        if (n<2)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 18; i++) {
            System.out.println(fibonacci.next());
        }
    }
}
