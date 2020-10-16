package com.cl.test;

import java.util.*;

/**
 * Created by cl on 2018/1/10.
 */
public class Test11 {
    public static void main(String[] args) {
        List<ListStringTest> result = new ArrayList<>();
        List<ListStringTest> stringTests = test4();
        System.out.println(stringTests.size());
        Set<String> strings = new HashSet<>();
        for (ListStringTest test : stringTests) {
            String index1 = test.getStr1() + test.getStr2();
            String index2 = test.getStr2() + test.getStr1();
            if (strings.contains(index1)) {
                continue;
            }
            if (strings.contains(index2)) {
                continue;
            }
            strings.add(index1);
            strings.add(index2);
            result.add(test);
        }
        System.out.println(result.size());
        for (ListStringTest test : result) {
            System.out.println(test);
        }
    }

    public static List<ListStringTest> test4() {
        List<ListStringTest> stringTests = new ArrayList<>();
        List<String> list = getStringList();
        for (int i = 0; i < 10; i++) {
            String stri = list.get(i);
            for (int j = 0; j < 10; j++) {
                if (i != j) {
                    String strj = list.get(j);
                    stringTests.add(new ListStringTest(stri, strj));
                }
            }
        }
        return stringTests;
    }

    public static List getStringList() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++)
            list.add("js" + i);
        return list;
    }

    static class ListStringTest {
        private String str1;
        private String str2;

        public ListStringTest(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }

        public String getStr1() {
            return str1;
        }

        public void setStr1(String str1) {
            this.str1 = str1;
        }

        public String getStr2() {
            return str2;
        }

        public void setStr2(String str2) {
            this.str2 = str2;
        }

        @Override
        public String toString() {
            return "ListStringTest{" +
                    "str1='" + str1 + '\'' +
                    ", str2='" + str2 + '\'' +
                    '}';
        }
    }
}
