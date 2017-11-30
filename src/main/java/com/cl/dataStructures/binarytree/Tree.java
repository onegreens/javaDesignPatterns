package com.cl.dataStructures.binarytree;

import java.util.Stack;

/**
 * Created by cl on 2017/9/19.
 * 二叉树的简单演示
 */
public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    /**
     * 根据键查找值
     *
     * @param key
     * @return
     */
    public Node find(int key) {//根据键值查找数值
        Node current = root;
        while (current.iData != key) { //如果不相等
            if (current.iData > key) //需要根据插入方法去判断哪边是左右
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;//没有就返回空
        }
        return current;
    }

    /**
     * 插入节点
     * 必须先找到需要插入的地方
     *
     * @param id
     * @param value
     */
    void insert(int id, double value) {
        Node newNode = new Node(id, value);

        if (root == null) //没有值的时候自然是第一个
            root = newNode;
        else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (current.iData > id) {
                    //键值大的放在左边
                    current = current.leftChild;
                    if (current == null) {//如果子节点为空
                        //进行赋值并返回
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    //键值小的放在右边
                    current = current.rightChild;
                    if (current == null) {//如果子节点为空
                        //进行赋值并返回
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }
        }

    }

    /**
     * 删除节点
     * 只是删除当前节点 需要把当前节点的子节点衔接到其他节点上面
     * 主要是三种情况
     *
     * @param key
     * @return
     */
    boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;//用于判断是不是左节点
        //1. 寻找到对应键值的节点
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
        }
        //2.找不到对应需要删除的节点
        if (current == null)
            return false;
        //情况一：该节点为叶节点，即没有子节点
        if (current.leftChild == null && current.rightChild == null) {
            //为第一个节点
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        //情况二：该节点有左节点，需要将左节点移至父节点
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)//为父节点的左节点？
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }
        //情况三：该节点有右节点，需要将右节点移至父节点
        else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)//为父节点的左节点？
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }
        //情况四：该节点有两个子节点
        else {
            //找到当前的子节点的某个节点的右节点为空的节点 替换为当前节点
            //简单的说是替换
            Node successor = getSuccess(current);
            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    /**
     * 寻找对应的节点的左子节点
     *
     * @param delNode
     * @return
     */
    Node getSuccess(Node delNode) {
        Node successParent = delNode;
        Node success = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            successParent = success;
            success = current;
            current = current.leftChild;
        }
        if (success != delNode.rightChild) {
            successParent.leftChild = success.rightChild;
            success.rightChild = delNode.rightChild;
        }
        return success;
    }

    void traverse(int traverseType) {
        System.out.println("");
        switch (traverseType) {
            case 1:
                System.out.println("preOrder traversal:");
                preOrder(root);
                break;
            case 2:
                System.out.println("inOrder traversal:");
                inOrder(root);
                break;
            case 3:
                System.out.println("postOrder traversal:");
                postOrder(root);
                break;
        }
    }

    void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
        }


    }

    void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    public Node minimum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node maximum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    void displayTree() {
        Stack global = new Stack();
        global.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(".................................................");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (global.isEmpty() == false) {
                Node temp = (Node) global.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    System.out.print(" " + temp.dData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild == null || temp.rightChild == null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++) {
                    System.out.print(" ");
                }
                System.out.println();
                nBlanks /= 2;
                while (localStack.isEmpty() == false)
                    global.push(localStack.pop());
            }
            System.out.println(".................................................");
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        for (int i = 1; i < 50; i++) {
            tree.insert((int) (Math.random() * 99), Math.random() * 99);
        }
        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
    }

}

class Node {
    public int iData; //关键词
    public double dData; //数值
    public Node leftChild; //左节点
    public Node rightChild; //右节点

    public Node(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", dData=" + dData +
                '}';
    }


}