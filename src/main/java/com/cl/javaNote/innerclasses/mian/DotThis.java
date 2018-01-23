package com.cl.javaNote.innerclasses.mian;//: innerclasses/DotThis.java
// Qualifying access to the outer-class object.

/**
 * 内部类对外部对象的引用
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
            // A plain "this" would be Inner's "this"
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis dt2 = new DotThis();
        DotThis.Inner dti = dt.inner();
        DotThis.Inner dti2 = dt2.inner();
        dti.outer().f();
        System.out.println(dt.equals(dti2.outer()));
    }
} /* Output:
DotThis.f()
*///:~
