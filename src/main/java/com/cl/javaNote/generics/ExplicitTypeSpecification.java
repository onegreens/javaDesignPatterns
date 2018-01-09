package com.cl.javaNote.generics;//: generics/ExplicitTypeSpecification.java

import com.cl.javaNote.entity.Person;
import com.cl.javaNote.entity.Pet;
import com.cl.javaNote.util.New;

import java.util.List;
import java.util.Map;

/**
 * 显示的
 * 类型说明
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
} ///:~
