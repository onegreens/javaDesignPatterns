package com.cl.test;

import java.util.*;

/**
 * Created by cl on 2018/1/10.
 */
public class Test10 {
    public static void main(String[] args) {
//        test2();
//        test1();
        test4();
    }

    public static void test4() {
        Set<ListStringTestList> test = new HashSet<>();
        List<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        List<String> list1 = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        test.add(new ListStringTestList(list));
        test.add(new ListStringTestList(list1));
        System.out.println(test.size());//2

    }

    public static void test3() {
        Set<ListStringTestList> test = new HashSet<>();
        List<String> list = new ArrayList<>();
        list.add("str1");
        list.add("str2");
        test.add(new ListStringTestList(list));
        test.add(new ListStringTestList(list));
        System.out.println(test.size());//1

    }

    public static void test1() {
        Set<ListStringTest> test = new HashSet<>();
        test.add(new ListStringTest("str1", "str2"));
        test.add(new ListStringTest("str1", "str2"));
        System.out.println(test.size());//1
    }

    public static void test2() {
        Set<ListStringTest> test = new HashSet<>();
        test.add(new ListStringTest("str1", "str2"));
        test.add(new ListStringTest("str2", "str1"));
        System.out.println(test.size());//2
    }



    static class ListStringTestList {
        List<String> list;

        public ListStringTestList(List<String> list) {
            this.list = list;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListStringTestList that = (ListStringTestList) o;
            return Objects.equals(list, that.list);
        }

        @Override
        public int hashCode() {

            return Objects.hash(list);
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    static class ListStringTest {
        private String str1;
        private String str2;

        public ListStringTest(String str1, String str2) {
            this.str1 = str1;
            this.str2 = str2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListStringTest that = (ListStringTest) o;
            return Objects.equals(str1, that.str1) &&
                    Objects.equals(str2, that.str2);
        }

        @Override
        public int hashCode() {

            return Objects.hash(str1, str2);
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
    }
}
