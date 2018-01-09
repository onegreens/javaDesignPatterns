package com.cl.javaNote.innerclasses.practice;

/**
 * Created by cl on 2018/1/5.
 * 创建一个Cycle接口机器Unicycle Bicycle Tricycle实现
 * 对每种类型都创建相应的工厂
 */
public class Practice16 {
    public static void serviceConsumer(CycleFactory fact) {
        Cycle s = fact.getCycle();
        s.getName();
    }

    public static void main(String[] args) {
        serviceConsumer(Unicycle.cycleFactory);
        // Implementations are completely interchangeable:
        serviceConsumer(Bicycle.cycleFactory);
        serviceConsumer(Tricycle.cycleFactory);
    }
}

interface Cycle {
    void getName();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public void getName() {
        System.out.println("Unicycle");
    }

    protected static CycleFactory cycleFactory = new CycleFactory() {
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}

class Bicycle implements Cycle {
    public void getName() {
        System.out.println("Bicycle");
    }

    protected static CycleFactory cycleFactory = new CycleFactory() {
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}

class Tricycle implements Cycle {
    public void getName() {
        System.out.println("Tricycle");
    }

    protected static CycleFactory cycleFactory = new CycleFactory() {
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}