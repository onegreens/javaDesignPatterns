package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 */
public class Link {
    public long lData; //item
    //以上是每个节点的数据存储
    public Link next; // 关联到下一个数据 自引式定义

    public Link(long lData) {
        this.lData = lData;
    }

    public void displayLData() {
        System.out.println(lData);
    }

}

class Link1 {
    public int iData; //item key
    public double dData; //item
    //以上是每个节点的数据存储
    public Link1 next; // 关联到下一个数据 自引式定义

    public Link1(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    @Override
    public String toString() {
        return "Link1{" +
                "iData=" + iData +
                ", dData=" + dData +
                '}';
    }
}

class DLink {
    public long dData; //item
    public DLink next;
    public DLink previous;

    public DLink(long dData) {
        this.dData = dData;
    }

    public void dispaly() {
        System.out.println("dData : " + dData);
    }
}