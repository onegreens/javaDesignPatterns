package com.cl.javaNote.containers;

import com.cl.javaNote.util.CountingGenerator;
import com.cl.javaNote.util.Generator;
import com.cl.javaNote.util.RandomGenerator;

import static com.cl.javaNote.util.Print.print;

import java.util.Iterator;

/**
 * Created by cl on 2017/10/7.
 */

class Letters implements Generator<Pair<Integer,String>>,
        Iterable<Integer> {
    private int size = 9;
    private int number = 1;
    private char letter = 'A';
    public Pair<Integer,String> next() {
        return new Pair<Integer,String>(
                number++, "" + letter++);
    }
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public Integer next() { return number++; }
            public boolean hasNext() { return number < size; }
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

public class MapDataTest {
    public static void main(String[] args) {
        // Pair Generator:
        print(MapData.map(new Letters(), 11));
        // Two separate generators:
        print(MapData.map(new CountingGenerator.Character(),
                new RandomGenerator.String(3), 8));
        // A key Generator and a single value:
        print(MapData.map(new CountingGenerator.Character(),
                "Value", 6));
        // An Iterable and a value Generator:
        print(MapData.map(new Letters(),
                new RandomGenerator.String(3)));
        // An Iterable and a single value:
        print(MapData.map(new Letters(), "Pop"));
    }
}