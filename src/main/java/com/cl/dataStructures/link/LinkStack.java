package com.cl.dataStructures.link;

/**
 * Created by cl on 2017/9/13.
 */
public class LinkStack {
    private LinkStackList stackList;

    public LinkStack() {
        this.stackList = new LinkStackList();
    }

    public void push(long value) {
        stackList.insert(value);
    }

    public long pop() {
        return stackList.deleteFirst();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public void displayStack() {
        System.out.println("display: >>>>");
        stackList.display();
    }

    public static void test1() {
        LinkStack stack = new LinkStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.displayStack();
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.displayStack();
        stack.pop();
        stack.pop();
        stack.displayStack();
    }

    public static void main(String[] args) {
        LinkStack.test1();
    }
}

class LinkStackList {
    private Link first;

    public LinkStackList() {
        this.first = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 在链表头插入一个数据项
     */
    public void insert(long dData) {
        Link newLink1 = new Link(dData);//创建一个新的节点
        newLink1.next = first;//为这个新节点添加附属值
        first = newLink1;//转为新节点
    }

    /**
     * 在链表头删除一个数据项
     *
     * @return
     */
    public long deleteFirst() {
        Link temp = first;//获取当前节点
        first = first.next;//当前节点退为下一个节点
        return temp.lData;
    }

    /**
     * 遍历显示
     */
    public void display() {
        System.out.println("List (first -> last ):");
        Link current = first;
        while (current != null) {
            System.out.println(current.lData);
            current = current.next;
        }
        System.out.println(" ");
    }
}


