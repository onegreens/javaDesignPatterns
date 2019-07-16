package com.cl.leetcode.arithmetic.simple.number;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            int[] index = grid[i];
            for (int j = 0; j < index.length; j++) {
                int num = index[j];
                if (num == 0) {
                    continue;
                } else {
                    int base = 0;
                    if (i == 0) base++;
                    else if (grid[i - 1][j] == 0) base++;
                    if (i == grid.length - 1) base++;
                    else if (grid[i + 1][j] == 0) base++;
                    if (j == 0) base++;
                    else if (index[j - 1] == 0) base++;
                    if (j == index.length - 1) base++;
                    else if (index[j + 1] == 0) base++;
                    sum += base;
                }
            }
        }
        return sum;

    }

}
