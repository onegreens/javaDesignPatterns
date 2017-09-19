package com.cl.dataStructures.recursion;

/**
 * Created by cl on 2017/9/18.
 * 消除递归
 * 通过栈实现递归的效果
 */
public class StackTriangle {
    static int theNumber;
    static int theAnswer;
    static int codePart;
    static StackP theStack;
    static Params theseParams;

    public static void main(String[] args) {
        theNumber = 10;
        recTriangle();
        System.out.println("triangle = " + theAnswer);
    }

    public static void recTriangle() {
        theStack = new StackP(10000);
        codePart = 1;
        while (step() == false)
            ;

    }

    public static boolean step() {
        switch (codePart) {
            case 1:
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                break;
            case 2:
                theseParams = theStack.peek();
                if (theseParams.n == 1) {
                    theAnswer = 1;
                    codePart = 5;
                } else
                    codePart = 3;
                break;
            case 3:
                Params newParams = new Params(theseParams.n - 1, 4);
                theStack.push(newParams);
                codePart = 2;
                break;
            case 4:
                theseParams = theStack.peek();
                theAnswer = theAnswer + theseParams.n;
                codePart = 5;
                break;
            case 5:
                theseParams = theStack.peek();
                codePart = theseParams.returnAddress;
                theStack.pop();
                break;
            case 6:
                return true;
        }
        return false;
    }

}

class Params {
    public int n;
    public int returnAddress;

    public Params(int n, int returnAddress) {
        this.n = n;
        this.returnAddress = returnAddress;
    }
}

class StackP {
    private int maxSize;
    private Params[] stackArray;
    private int top;

    public StackP(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new Params[maxSize];
        top = -1;
    }

    public void push(Params p) {
        stackArray[++top] = p;
    }

    public Params pop() {
        return stackArray[top--];
    }

    public Params peek() {
        return stackArray[top];
    }
}
