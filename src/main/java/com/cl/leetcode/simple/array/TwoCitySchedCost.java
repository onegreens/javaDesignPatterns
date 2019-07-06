package com.cl.leetcode.simple.array;

import com.cl.dataStructures.array.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * <p>
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 * <p>
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class TwoCitySchedCost {
    public static void main(String[] args) {
        int[][] costs = {{918, 704}, {77, 778}, {239, 457}, {284, 263}, {872, 779}, {976, 416}, {860, 518}, {13, 351}, {137, 238}, {557, 596}, {890, 227}, {548, 143}, {384, 585}, {165, 54}};
        System.out.println(twoCitySchedCost(costs));
    }

    public static int twoCitySchedCost(int[][] costs) {
//todo
        return 0;
    }
}
