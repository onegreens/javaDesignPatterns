package com.cl.pattern.packaging.sort;

/**
 * Created by cl on 2017/7/13.
 */
public class Duck implements Comparable{
    String name;
    Integer weight;

    public Duck(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }



    @Override
    public String toString() {
        return "Duck{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    //自定义排序 当调用sort方法是，会使用这个方法进行排序
    public int compareTo(Object o) {
        Duck otherDuck = (Duck)o;
        if(this.weight> otherDuck.weight){
            return 1;

        }else if (this.weight == otherDuck.weight) {
            return 0;

        }else {
            return -1;

        }
    }
}
