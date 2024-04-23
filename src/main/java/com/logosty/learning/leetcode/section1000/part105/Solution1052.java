package com.logosty.learning.leetcode.section1000.part105;

/**
 * @author logosty(ganyingle) on 2024/4/23 17:09
 * description: 1052. 爱生气的书店老板 中等
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i
 * 分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * <p>
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 示例 2：
 * <p>
 * 输入：customers = [1], grumpy = [0], minutes = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == customers.length == grumpy.length
 * 1 <= minutes <= n <= 2 * 104
 * 0 <= customers[i] <= 1000
 * grumpy[i] == 0 or 1
 */
public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int result = 0;
        int length = customers.length;

        int total = 0;
        for (int i = 0; i < length; i++) {
            total += grumpy[i] == 1 ? 0 : customers[i];
        }
        if (minutes == 0) {
            return total;
        }

        //初始化0位置
        for (int i = 0; i < minutes; i++) {
            total += grumpy[i] * customers[i];
        }
        result = Math.max(result, total);

        int endCalmDown;
        for (int i = 1; i + minutes - 1 < length; i++) {
            endCalmDown = i + minutes - 1;

            total -= grumpy[i - 1] * customers[i - 1];
            total += grumpy[endCalmDown] * customers[endCalmDown];
            result = Math.max(result, total);
        }

        return result;
    }
}
