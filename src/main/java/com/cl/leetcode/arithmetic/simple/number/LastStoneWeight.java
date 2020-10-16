package com.cl.leetcode.arithmetic.simple.number;

import com.cl.dataStructures.array.Array;

import java.util.Arrays;

/**
 * 有一堆石头，每块石头的重量都是正整数。
 * <p>
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * <p>
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(nums));
    }

    public static int lastStoneWeight(int[] stones) {
        int i = stones.length - 1;
        int num = stones.length;
        while (num > 1) {
            Arrays.sort(stones);
            int ival = stones[i] - stones[i - 1];
            stones[i] = 0;
            num--;
            stones[i - 1] = ival;
            if (ival == 0) num--;
        }
        Arrays.sort(stones);
        return stones[i];
    }
}
