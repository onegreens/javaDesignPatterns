package com.cl.javaNote.collection;

import java.util.LinkedList;

/**
 * Created by cl on 2017/9/22.
 * 通过LinkedList实现Stack
 */
public class Stack_LinkedList<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T v) {
        storage.addFirst(v);
    }

    public T peek() {
        return storage.getFirst();
    }

    public T pop() {
        return storage.removeFirst();
    }

    public boolean empty() {
        return storage.isEmpty();
    }

    public String toString() {
        return storage.toString();
    }

    public static void main(String[] args) {
        Stack_LinkedList<String> stack = new Stack_LinkedList<String>();
        for (String s : "My dog has fleas".split(" "))
            stack.push(s);
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
    }
}
