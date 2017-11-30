package com.cl.dataStructures.heap;

/**
 * Created by cl on 2017/10/9.
 * 堆的简单实例
 *
 *
 */
public class HeapApp {
    public static void main(String[] args) {
        int value,value2;
        Heap theHeap = new Heap(31);
        boolean success;

        theHeap.insert(70);
        theHeap.insert(20);
        theHeap.insert(30);
        theHeap.insert(60);
        theHeap.insert(120);
        theHeap.insert(50);
        theHeap.insert(80);
        theHeap.insert(90);
        theHeap.insert(10);
        theHeap.insert(100);

        theHeap.displayHeap();


    }
}

class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int max) {
        maxSize = max;
        heapArray = new Node[max];
        currentSize = 0;
    }

    boolean isEmpty() {
        return currentSize == 0;
    }

    boolean insert(int key) {
        //先检查确定数组不满
        if (currentSize == maxSize)
            //已达到限制，无法继续添加
            return false;
        //用参数传递的关键字值创建一个新的节点
        Node newNode = new Node(key);
        //把这个节点插入到数组的末端
        heapArray[currentSize] = newNode;
        //把这个节点向上移动到适当的位置
        trickleUp(currentSize++);
        return true;
    }

    /**
     * 找到这个位置的父节点，然后把这个节点保存在一个名为bottom的变量里
     *
     * @param index 新插入的数据项的下标
     */
    void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        //变量index沿着路径朝跟的方向上行，依次指向每一个节点
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            //把父节点复制到index锁指的单元中，即向下移动了父节点
            heapArray[index] = heapArray[parent];
            //通过把父节点的下标传给index,使得index上移了
            index = parent;
            //并且把父节点的下标基于了它的父节点
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    /**
     * 返回移除的节点
     *
     * @return
     */
    Node remove() {
        //保存根节点
        Node root = heapArray[0];
        //把最后一个节点（下标为currentSize-1）放到根的位置上
        heapArray[0] = heapArray[--currentSize];
        //把这个节点放到适当的位置
        trickleDown(0);
        return root;
    }

    void trickleDown(int index) {
        int largerChild;
        //把下标为index的节点保存到一个变量的top中
        Node top = heapArray[index];
        //只要还有子节点
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            //检查是否有右子节点 比较两个子节点的关键字
            if (rightChild < currentSize &&
                    heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                largerChild = rightChild;
            else
                largerChild = leftChild;
            //检查原来节点的关键字是否大于largerChild
            if (top.getKey() >= heapArray[largerChild].getKey())
                break;
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        //把存储在top中的节点恢复到适当的位置上，即index所指的位置
        heapArray[index] = top;
    }

    boolean change(int index, int newValue) {
        //检查参数是否合法
        if (index < 0 || index >= currentSize)
            return false;
        //修改参数的值
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);

        //如果节点优先级提高了，就向上筛选节点；
        //如果优先级下降了，就向下筛选节点
        if (oldValue < newValue)
            trickleUp(index);
        else trickleDown(index);
        return true;
    }

    void displayHeap() {
        System.out.println("heapArray: ");
        for (int m = 0; m < currentSize; m++)
            if (heapArray[m] != null)
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        System.out.println();

        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".......................";
        System.out.println(dots+dots);

        while (currentSize>0){
            if (column== 0)
                for (int i = 0; i < nBlanks; i++) {
                    System.out.print(' ');
                }
            System.out.print(heapArray[j].getKey());
            if(++j == currentSize)
                break;
            if (++column == itemsPerRow){
                nBlanks/= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            }else
                for (int i = 0; i < nBlanks*2-2; i++) {
                    System.out.print(" ");
                }
        }
        System.out.println("\n"+dots+dots);
    }

}

class Node {
    private int iData;

    public Node(int iData) {
        this.iData = iData;
    }

    public int getKey() {
        return iData;
    }

    public void setKey(int iData) {
        this.iData = iData;
    }
}
