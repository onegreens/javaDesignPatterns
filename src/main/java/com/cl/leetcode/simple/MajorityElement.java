package com.cl.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums =
                {3, 3, 1, 1, 1, 2, 2, 2, 2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int half = len / 2;
        int max = 0;
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int start = nums[i];
            int num = 1;
            if (map.get(start) != null) {
                num += map.get(start);
            }
            map.put(start, num);
            if (num > half) {
                return start;
            }
            if(num>max){
                max = num;
                index = start;
            }
        }
        return index;
    }

    public static int majorityElement1(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int half = len / 2;
        for (int i = 0; i < len - 1; i++) {
            int start = nums[i];
            int num = 1;
            boolean change = true;
            for (int j = i + 1; j < len; j++) {
                if (start == nums[j]) {
                    num++;
                } else {
                    if (change) {
                        change = false;
                        i = j - 1;
                    }
                }
                if (half - num > len - j) {
                    break;
                }
            }
            if (num > half) {
                return start;
            }
        }
        return 0;
    }
}
