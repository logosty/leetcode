package com.logosty.learning.leetcode.section700.part73;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author logosty(ganyingle) on 2024/3/26 15:14
 * description: 735. 小行星碰撞 中等
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 *
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 *
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 *
 *
 *
 * 示例 1：
 *
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * 示例 2：
 *
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * 示例 3：
 *
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 *
 * 提示：
 *
 * 2 <= asteroids.length <= 104
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        int length = asteroids.length;
        Stack<Integer> stack = new Stack<>();
        boolean[] dead = new boolean[length];

        //修正右移的数据
        for (int i = length - 1; i >= 0; i--) {
            int curAsteroid = asteroids[i];

            //左移的行星
            if (curAsteroid < 0) {
                if (stack.empty() || curAsteroid <= asteroids[stack.peek()]) {
                    stack.push(i);
                }
            } else {
                //右移
                //比左移小，就摧毁，
                // 否则持续清空栈直到比左移小
                while (!stack.empty()) {
                    if (asteroids[stack.peek()] + curAsteroid < 0) {
                        dead[i] = true;
                        break;
                    } else if (asteroids[stack.peek()] + curAsteroid == 0) {
                        dead[i] = true;
                        stack.pop();
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        //修正左移的数据
        stack.clear();
        for (int i = 0; i < length; i++) {
            int curAsteroid = asteroids[i];
            if (curAsteroid > 0) {
                if (stack.empty() || curAsteroid >= asteroids[stack.peek()]) {
                    stack.push(i);
                }
            } else {
                while (!stack.empty()) {
                    if (asteroids[stack.peek()] + curAsteroid > 0) {
                        dead[i] = true;
                        break;
                    } else if (asteroids[stack.peek()] + curAsteroid == 0) {
                        dead[i] = true;
                        stack.pop();
                        break;
                    } else {
                        stack.pop();

                    }
                }
            }
        }

        //根据dead数据组合结果
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < dead.length; i++) {
            if (!dead[i]) {
                list.add(asteroids[i]);
            }
        }
        return list.stream().mapToInt(value -> value).toArray();

    }
}
