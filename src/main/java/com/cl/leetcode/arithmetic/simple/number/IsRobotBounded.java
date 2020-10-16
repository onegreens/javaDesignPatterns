package com.cl.leetcode.arithmetic.simple.number;

/**
 * 在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 * 机器人按顺序执行指令 instructions，并一直重复它们。
 * <p>
 * 只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："GGLLGG"
 * 输出：true
 * 解释：
 * 机器人从 (0,0) 移动到 (0,2)，转 180 度，然后回到 (0,0)。
 * 重复这些指令，机器人将保持在以原点为中心，2 为半径的环中进行移动。
 * 示例 2：
 * <p>
 * 输入："GG"
 * 输出：false
 * 解释：
 * 机器人无限向北移动。
 * 示例 3：
 * <p>
 * 输入："GL"
 * 输出：true
 * 解释：
 * 机器人按 (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ... 进行移动。
 */
public class IsRobotBounded {
    public static void main(String[] args) {
        System.out.println(isRobotBounded("GGLLGG"));
        System.out.println(isRobotBounded("GG"));
        System.out.println(isRobotBounded("GL"));
        System.out.println(isRobotBounded("GLGLGGLGL"));
    }

    public static boolean isRobotBoundeds(String instructions) {
        int[] nums = {0, 0, 0, 0};//北 东 南 西
        int index = 0;//北
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'G':
                    nums[index] += 1;
                    break;
                case 'L':
                    index--;
                    if (index == -1) index = 3;
                    break;
                case 'R':
                    index++;
                    if (index == 4) index = 0;
                    break;
                default:
                    break;
            }
        }
        return nums[1] - nums[3] + nums[0] - nums[2] == 0;
    }

    public static boolean isRobotBounded(String instructions) {
        return isRobotBoundeds(instructions) || isRobotBoundeds(instructions + instructions) || isRobotBoundeds(instructions + instructions + instructions + instructions);
    }
}

