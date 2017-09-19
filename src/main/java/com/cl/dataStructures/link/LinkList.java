package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 * 单链表
 */

public class LinkList {
    private Link1 first;

    public LinkList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在链表头插入一个数据项
     *
     * @param iData
     * @param dData
     */
    public void insert(int iData, double dData) {
        Link1 newLink1 = new Link1(iData, dData);//创建一个新的节点
        newLink1.next = first;//为这个新节点添加附属值
        first = newLink1;//转为新节点
    }

    /**
     * 在链表头删除一个数据项
     *
     * @return
     */
    public Link1 deleteFirst() {
        Link1 temp = first;//获取当前节点
        first = first.next;//当前节点退为下一个节点
        return temp;
    }

    /**
     * 遍历显示
     */
    public void display() {
        System.out.println("List (first -> last ):");
        Link1 current = first;
        while (current != null) {
            System.out.println(current.toString());
            current = current.next;
        }
        System.out.println(" ");
    }

    /**
     * 在链表中查找指定关键字的链节点
     *
     * @return
     */
    public Link1 find(int key) {
        Link1 current = first;//从第一个开始
        while (current.iData != key) {//判断是否符合
            if (current.next == null)//遍历完结
                return null;
            else
                current = current.next;//指向下一个节点
        }
        return current;
    }

    /**
     * 删除包含指定关键字的链节点
     *
     * @return
     */
    public Link1 delete(int key) {
        Link1 current = first;//从第一个开始
        Link1 previous = first;
        while (current.iData != key) {//判断是否符合
            if (current.next == null)//遍历完结
                return null;
            else {
                previous = current;//存储当前节点
                current = current.next;//指向下一个节点
            }
        }
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;//把前一个链节点的next字段赋值为当前链节点的下一个链节点
        return current;
    }

    public static void test1() {
        LinkList linkList = new LinkList();
        linkList.insert(1, 11);
        linkList.insert(2, 22);
        linkList.insert(3, 33);
        linkList.insert(4, 44);
        linkList.insert(5, 55);

        linkList.display();

        while (!linkList.isEmpty()) {
            Link1 Link1 = linkList.deleteFirst();
            System.out.println(Link1.toString());
        }
    }

    public static void test2() {
        LinkList linkList = new LinkList();
        linkList.insert(1, 11);
        linkList.insert(2, 22);
        linkList.insert(3, 33);
        linkList.insert(4, 44);
        linkList.insert(5, 55);
        linkList.insert(6, 66);

        linkList.display();

        Link1 Link11 = linkList.find(1);
        System.out.println(Link11);

        Link1 Link12 = linkList.delete(6);
        linkList.delete(3);
        System.out.println(Link12.toString());
        linkList.display();

    }

    public static void main(String[] args) {
        LinkList.test2();
    }
}