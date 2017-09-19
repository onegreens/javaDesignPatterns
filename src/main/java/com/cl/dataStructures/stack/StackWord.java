package com.cl.dataStructures.stack;

/**
 * Created by cl on 2017/9/12.
 * 单词逆序
 */
public class StackWord {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackWord(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char value) {
        stackArray[++top] = value;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peck() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        Reverser reverser = new Reverser("asdfghjk");
        System.out.println(reverser.doRev());
    }
}

class Reverser{
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doRev(){
        int stackSize = input.length();
        StackWord srackWord = new StackWord(stackSize);

        for (int i = 0; i < stackSize; i++) {
            srackWord.push(input.charAt(i));
        }
        output = "";
        while (!srackWord.isEmpty()){
            output = output + srackWord.pop();
        }
        return output;
    }
}
