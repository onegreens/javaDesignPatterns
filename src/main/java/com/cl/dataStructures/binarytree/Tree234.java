package com.cl.dataStructures.binarytree;

/**
 * Created by cl on 2017/9/25.
 */
public class Tree234 {
    Node234 root = new Node234();

    /**
     * 返回数据项在节点的数据项数组的索引值
     * @param key
     * @return
     */
    int find(long key) {
        Node234 curNode = root;
        int childNumber;
        while (true) {
            //查询对应节点
            if ((childNumber = curNode.findItem(key)) != -1)
                return childNumber;
            else
                //如果是叶节点，则直接返回
                if (curNode.isLeaf())
                    return -1;
                else
                    //切换到其他节点
                    curNode = getNextChild(curNode, key);
        }
    }

    Node234 getNextChild(Node234 theNode, long theValue) {
        int j;
        int nums = theNode.getNumItems();
        for (j = 0; j < nums; j++)
            if (theValue < theNode.getItem(j).dData)
                return theNode.getChild(j);
        return theNode.getChild(j);
    }

    void insert(long value) {
        Node234 curNode = root;
        DataItem tempItem = new DataItem(value);

        while (true) {
            if (curNode.isFull()) {//节点是满的
                //拆分
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, value);
            } else if (curNode.isLeaf())
                break;
            else curNode = getNextChild(curNode, value);
        }
        curNode.insertItem(tempItem);
    }

    void split(Node234 thisNode) {
        DataItem itemB, itemC;
        Node234 parent, child2, child3;
        int itemIndex;

        //最右边的两个数据项从节点中删掉并保存起来
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();

        //断开最右边的两个子节点的链接并保存
        child2 = thisNode.disconnectChild(2);
        child3 = thisNode.disconnectChild(3);

        //创建新的节点，该节点将至于被分裂节点的右边
        Node234 newRight = new Node234();

        if (thisNode == root) {
            //如果要分裂的是根
            //创建新根，设定原根为子节点
            root = new Node234();
            parent = root;
            root.connectChild(0, thisNode);
        } else
            parent = thisNode.getParent();

        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();

        //父节点为新的数据项和新的链接腾出位置
        for (int j = n - 1; j > itemIndex; j--) {
            //所有子节点后移
            Node234 temp = parent.disconnectChild(j);
            parent.connectChild(j + 1, temp);
        }
        parent.connectChild(itemIndex + 1, newRight);
        newRight.insertItem(itemC);
        newRight.connectChild(0, child2);
        newRight.connectChild(1, child3);
    }

    void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    void recDisplayTree(Node234 thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child= " + childNumber + " ");
        thisNode.displayNode();

        int numItems = thisNode.getNumItems();
        for (int i = 0; i < numItems + 1; i++) {
            Node234 nextNode = thisNode.getChild(i);
            if (nextNode != null)
                recDisplayTree(nextNode, level + 1, i);
            else
                return;

        }
    }

    public static void main(String[] args) {
        Tree234 tree234 = new Tree234();
        for (int i = 0; i < 50; i++) {
            tree234.insert((long) (Math.random()*20));
        }
        tree234.displayTree();
    }


}

/**
 * 数据项
 */
class DataItem {
    public long dData;

    public DataItem(long dData) {
        this.dData = dData;
    }

    void displayItem() {
        System.out.print("  " + dData);
    }
}

class Node234 {
    static final int ORDER = 4;
    int numItems;
    Node234 parent;
    Node234 childArray[] = new Node234[ORDER];
    DataItem itemArray[] = new DataItem[ORDER - 1];

    void connectChild(int childItem, Node234 child) {
        childArray[childItem] = child;
        if (child != null)
            child.parent = this;
    }

    Node234 disconnectChild(int childNum) {
        Node234 temp = childArray[childNum];
        childArray[childNum] = null;
        return temp;
    }

    Node234 getChild(int childNum) {
        return childArray[childNum];
    }

    Node234 getParent() {
        return parent;
    }

    boolean isLeaf() {
        return (childArray[0] == null) ? true : false;
    }

    int getNumItems() {
        return numItems;
    }

    DataItem getItem(int index) {
        return itemArray[index];
    }

    boolean isFull() {
        return (numItems == ORDER - 1) ? true : false;
    }

    int findItem(long key) {
        for (int i = 0; i < ORDER - 1; i++) {
            if (itemArray[i] == null)
                break;
            else if (itemArray[i].dData == key)
                return i;
        }
        return -1;
    }

    int insertItem(DataItem newItem) {
        numItems++;//节点数据项增加
        long newkey = newItem.dData;

        //ORDER-2:每个节点最多有三个数据项，四个子节点，ORDER表示子节点的数量
        //此时是添加数据项，最多是三，由于数组是用零开始计算的。所以应该是2
        for (int j = ORDER - 2; j >= 0; j--) {
            //对节点的数据项重新排序
            //由于是倒序，所以为空时继续
            if (itemArray[j] == null)
                continue;
            else {
                long itsKey = itemArray[j].dData;
                //对比后调整
                //可能会出现四个数据项
                if (newkey < itsKey)
                    itemArray[j + 1] = itemArray[j];
                else {
                    itemArray[j + 1] = newItem;
                    return j + 1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }

    DataItem removeItem() {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems - 1] = null;
        numItems--;
        return temp;
    }

    void displayNode() {
        for (int i = 0; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        System.out.println();
    }
}
