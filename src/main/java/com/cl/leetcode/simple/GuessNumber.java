package com.cl.leetcode.simple;

/**
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * <p>
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例 :
 * <p>
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class GuessNumber {
    public static void main(String[] args) {
        System.out.println(guessNumber(5));
    }

    public static int guessNumber(int n) {
        //TODO
        int min = 1;
        int max = n;
        while (min < max) {
            int half = min + (max - min) / 2;
            int flag = guess(half);
            if (flag == 0)
                return half;
            if (flag == 1) {
                min = half + 1;
            } else {
                max = half - 1;
            }
        }
        return min;
    }

    public static int guessNumber1(int n) {
        //TODO
        int min = 1;
        int max = n;
        while (min < max) {
            if (max - min == 1) {
                if (guess(min) == 0) {
                    return min;
                }
                if (guess(max) == 0) {
                    return max;
                }
            }
            int half = min + (max - min) / 2;
            int flag = guess(half);
            if (flag == 0)
                return half;
            if (flag == 1) {
                min = half;
            } else {
                max = half;
            }
        }
        return min;
    }

    public static int guess(int n) {
        int m = 2;
        if (m == n) return 0;
        if (m > n) return 1;
        return -1;
    }
}
