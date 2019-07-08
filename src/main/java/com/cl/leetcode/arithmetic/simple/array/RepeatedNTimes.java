package com.cl.leetcode.arithmetic.simple.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * <p>
 * 返回重复了 N 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] A) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            if (list.indexOf(num) > -1)
                return num;
            else list.add(num);
        }
        return A[0];
    }
}
