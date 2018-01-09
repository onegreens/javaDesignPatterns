package com.cl.javaNote.innerclasses.mian;//: innerclasses/Parcel10.java
// Using "instance initialization" to perform
// construction on an anonymous inner class.

/**
 *  如果定义一个匿名内部类时，并希望它使用一个在其外部定义的对象，那么要求参数的应用是final的
 */
public class Parcel10 {
  public Destination
  destination(final String dest, final float price) {
    return new Destination() {
      private int cost;
      // Instance initialization for each object:
      {
        cost = Math.round(price);
        if(cost > 100)
          System.out.println("Over budget!");
      }
      private String label = dest;
      public String readLabel() { return label; }
    };
  }	
  public static void main(String[] args) throws IllegalAccessException, InstantiationException {
    Parcel10 p = Parcel10.class.newInstance();
//    Parcel10 p = new Parcel10();
    Destination d = p.destination("Tasmania", 101.395F);
  }
} /* Output:
Over budget!
*///:~
