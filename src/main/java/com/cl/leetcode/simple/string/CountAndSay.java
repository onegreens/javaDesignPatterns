package com.cl.leetcode.simple.string;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        String str = "1";
        if (n == 1)
            return str;
        int num = 1;
        if (n == 2) {
            return num + str;
        }
        str = countAndSay(n - 1);
        String result = "";
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (i + 1 == str.length()) {
                result = result + num + str.charAt(len - 1);
            } else if (str.charAt(i) == str.charAt(i + 1)) {
                num++;
            } else {
                result = result + num + str.charAt(i);
                num = 1;
            }
        }
        return result;
    }

    public static String countAndSay2(int n) {
        String str = "1";
        if (n == 1)
            return str;
        int num = 1;
        if (n == 2) {
            return num + str;
        }
        str = countAndSay(n - 1);
        String[] strings = str.split("");
        str = "";
        for (int i = 0; i < strings.length; i++) {
            if (i + 1 == strings.length) {
                str = str + num + strings[strings.length - 1];
            } else if (strings[i].equals(strings[i + 1])) {
                num++;
            } else {
                str = str + num + strings[i];
                num = 1;
            }
        }
        return str;
    }


    public static String countAndSay1(int n) {
        int index = 1;
        String str = "1";
        while (index < n) {
            String[] strings = str.split("");
            str = "";
            int num = 1;
            if (strings.length == 1) {
                str = num + strings[0];
            } else {
                for (int i = 0; i < strings.length; i++) {
                    if (i + 1 == strings.length) {
                        str = str + num + strings[strings.length - 1];
                    } else if (strings[i].equals(strings[i + 1])) {
                        num++;
                    } else {
                        str = str + num + strings[i];
                        num = 1;
                    }
                }

            }
            index++;
        }
        return str;
    }
}
