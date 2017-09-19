package com.cl.dataStructures.stack;

/**
 * Created by cl on 2017/9/12.
 * 检测符号对称
 */
public class BracketChecker {
    private String input;

    public BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int stackSize = input.length();
        StackWord srackWord = new StackWord(stackSize);

        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    srackWord.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!srackWord.isEmpty()) {
                        char chx = srackWord.pop();
                        if ((ch == '}' && chx != '{') ||
                                (ch == ']' && chx != '[') ||
                                (ch == ')' && chx != '(')
                                ) {
                            System.out.println("Error:" + ch + " at " + i);
                        }
                    } else
                        System.out.println("Error:" + ch + " at " + i);
                    break;
                default:
                    break;
            }
        }
        if (!srackWord.isEmpty())
            System.out.println("error missing right delimiter");
    }

    public static void main(String[] args) {
        BracketChecker checker = new BracketChecker("{a[b(c)v]b}");
        checker.check();
    }
}
