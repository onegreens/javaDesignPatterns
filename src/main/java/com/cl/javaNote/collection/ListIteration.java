package com.cl.javaNote.collection;

import com.cl.javaNote.entity.Pet;
import com.cl.javaNote.entity.Pets;

import java.util.List;
import java.util.ListIterator;

/**
 * Created by cl on 2017/9/22.
 * ListIterator功能演示 可双向移动
 * 可现实当前元素前一个和后一个节点的索引
 * 可替换元素
 */
public class ListIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);
        ListIterator<Pet> it = pets.listIterator();
        while(it.hasNext())//双向显示
            System.out.print(it.next() + ", " + it.nextIndex() +
                    ", " + it.previousIndex() + "; ");
        System.out.println();
        // Backwards:
        while(it.hasPrevious())
            System.out.print(it.previous().id() + " ");
        System.out.println();
        System.out.println(pets);
        it = pets.listIterator(3);
        while(it.hasNext()) {
            it.next();
            it.set(Pets.randomPet());//替换元素
        }
        System.out.println(pets);
    }
}
