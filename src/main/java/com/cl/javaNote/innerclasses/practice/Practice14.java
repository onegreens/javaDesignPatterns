package com.cl.javaNote.innerclasses.practice;

//: interfaces/HorrorShow.java
// Extending an interface with inheritance.

/**
 * 修改interfaces/HorrorShow.java
 * 用匿名类实现DangerousMonster和Vampire
 */
public class Practice14 {
    static void u(Monster b) {
        b.menace();
    }

    static Vampire v() {
        return new Vampire() {
            public void menace() {
            }

            public void destroy() {
            }

            public void kill() {
            }

            public void drinkBlood() {
            }
        };
    }

    static DangerousMonster d() {
        return new DangerousMonster() {
            public void destroy() {

            }

            public void menace() {

            }
        };
    }


    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        u(d());
        v(d());
        u(v());
        v(v());
        w(v());
    }
}

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

///:~
