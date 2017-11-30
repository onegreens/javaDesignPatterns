package com.cl.javaNote.collection;

import com.cl.javaNote.entity.Hamster;
import com.cl.javaNote.entity.Pet;
import com.cl.javaNote.entity.Pets;
import com.cl.javaNote.entity.Rat;

import java.util.LinkedList;
import static com.cl.javaNote.util.Print.*;

/**
 * Created by cl on 2017/9/22.
 * LinkedList
 * 实现了基本的List接口
 * 插入和移除性能好 随机访问差
 * 可用作栈、队列、双端队列
 *
 */
public class LinkedListFeatures {
    public static void main(String[] args) {
        /*
        很多方法执行这相同的功能
         */
        LinkedList<Pet> pets =
                new LinkedList<Pet>(Pets.arrayList(5));
        print(pets);
        // Identical:
        print("pets.getFirst(): " + pets.getFirst());
        print("pets.element(): " + pets.element());
        // Only differs in empty-list behavior:
        print("pets.peek(): " + pets.peek());
        // Identical; remove and return the first element:
        print("pets.remove(): " + pets.remove());
        print("pets.removeFirst(): " + pets.removeFirst());
        // Only differs in empty-list behavior:
        print("pets.poll(): " + pets.poll());
        print(pets);
        pets.addFirst(new Rat());
        print("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        print("After offer(): " + pets);
        pets.add(Pets.randomPet());
        print("After add(): " + pets);
        pets.addLast(new Hamster());
        print("After addLast(): " + pets);
        print("pets.removeLast(): " + pets.removeLast());
    }
}
