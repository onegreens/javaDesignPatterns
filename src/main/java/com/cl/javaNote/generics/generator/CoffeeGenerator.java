//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package com.cl.javaNote.generics.generator;

import java.util.Iterator;
import java.util.Random;

/**
 * 随机生成对象
 *
 */
public class CoffeeGenerator
        implements Generator<Coffee>, Iterable<Coffee> {
    private Class[] types = {Latte.class, Mocha.class,
            Cappuccino.class, Americano.class, Breve.class,};
    private static Random rand = new Random(47);

    public CoffeeGenerator() {
    }

    // For iteration:
    private int size = 0;

    public CoffeeGenerator(int sz) {
        size = sz;
    }

    public Coffee next() {
        try {
            return (Coffee)
                    types[rand.nextInt(types.length)].newInstance();//核心步骤
            // Report programmer errors at run time:
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;

        public boolean hasNext() {
            return count > 0;
        }

        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();//区分方法的归属
        }

        public void remove() { // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    ;

    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    public static void main(String[] args) {
//        将多个对象放到一个数组里面，然后通过随机数获取值对应位置数组的对象
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0; i < 5; i++)
            System.out.println(gen.next());
        //由于CoffeeGenerator继承了Iterator 所以可以使用for
        for (Coffee c : new CoffeeGenerator(5))
            System.out.println(c);
    }
} /* Output:
Americano 0
Latte 1
Americano 2
Mocha 3
Mocha 4
Breve 5
Americano 6
Latte 7
Cappuccino 8
Cappuccino 9
*///:~
