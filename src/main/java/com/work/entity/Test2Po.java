package com.work.entity;

/**
 * Created by cl on 2017/12/15.
 */
public class Test2Po extends TestPo {
    public Test2Po(TestPo testPo) {
    }

    public Test2Po() {
    }

    public static void main(String[] args) {
        TestPo testPo = new TestPo();
        testPo.setId(1);
        Test2Po test2Po = (Test2Po) testPo;
        System.out.println(test2Po.getId());
    }
}
