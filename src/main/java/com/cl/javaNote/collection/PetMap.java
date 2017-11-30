package com.cl.javaNote.collection;

import com.cl.javaNote.entity.Cat;
import com.cl.javaNote.entity.Dog;
import com.cl.javaNote.entity.Hamster;
import com.cl.javaNote.entity.Pet;

import java.util.HashMap;
import java.util.Map;

import static com.cl.javaNote.util.Print.*;

/**
 * Created by cl on 2017/9/25.
 * 演示map
 */
public class PetMap {
    public static void main(String[] args) {
        Map<String,Pet> petMap = new HashMap<String,Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }
}
