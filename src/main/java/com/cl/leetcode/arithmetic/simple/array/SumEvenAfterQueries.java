package com.cl.leetcode.arithmetic.simple.array;

/**
 * 给出一个整数数组 A 和一个查询数组 queries。
 * <p>
 * 对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 * <p>
 * （此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 * <p>
 * 返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 */
public class SumEvenAfterQueries {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int len = queries.length;
        int[] result = new int[len];
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int val = A[i];
            if (val % 2 == 0)
                sum += val;
        }
        for (int i = 0; i < len; i++) {
            int[] query = queries[i];
            int val = query[0];
            int index = query[1];
            int a_val = A[index];
            if (a_val % 2 == 0) {
                sum -= val;
            }
            a_val = a_val + val;

            if (a_val % 2 == 0) {
                sum += a_val;
            }
            A[index] = a_val;
            result[i] = sum;
        }
        return result;
    }

}
