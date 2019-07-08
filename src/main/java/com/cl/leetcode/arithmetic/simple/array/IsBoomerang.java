package com.cl.leetcode.arithmetic.simple.array;

/**
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 * <p>
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 */
public class IsBoomerang {
    public boolean isBoomerang(int[][] points) {
        int diffx = points[1][0] - points[0][0];
        int diffy = points[1][1] - points[0][1];
        int diffx_ = points[2][0] - points[0][0];
        int diffy_ = points[2][1] - points[0][1];
        return !(diffx * diffy_ == diffy * diffx_);
    }
}
