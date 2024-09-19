package com.logosty.learning.leetcode.section2300.part233;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2024/9/18 17:40
 * description: 2332. 坐上公交的最晚时间 中等
 * 给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。同时给你一个下标从 0 开始长度为 m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同。
 *
 * 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
 *
 * 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x  且公交没有满，那么你可以搭乘这一辆公交。最早 到达的乘客优先上车。
 *
 * 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
 *
 * 注意：数组 buses 和 passengers 不一定是有序的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：buses = [10,20], passengers = [2,17,18,19], capacity = 2
 * 输出：16
 * 解释：
 * 第 1 辆公交车载着第 1 位乘客。
 * 第 2 辆公交车载着你和第 2 位乘客。
 * 注意你不能跟其他乘客同一时间到达，所以你必须在第二位乘客之前到达。
 * 示例 2：
 *
 * 输入：buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
 * 输出：20
 * 解释：
 * 第 1 辆公交车载着第 4 位乘客。
 * 第 2 辆公交车载着第 6 位和第 2 位乘客。
 * 第 3 辆公交车载着第 1 位乘客和你。
 *
 *
 * 提示：
 *
 * n == buses.length
 * m == passengers.length
 * 1 <= n, m, capacity <= 105
 * 2 <= buses[i], passengers[i] <= 109
 * buses 中的元素 互不相同 。
 * passengers 中的元素 互不相同 。
 */
public class Solution2332 {
        public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
            Arrays.sort(buses);
            Arrays.sort(passengers);
            int curCount = 0;
            int hasDonePassengerIndex = -1;  //最后一位已经上车的乘客
            for (int i = 0; i < buses.length; i++) {
                int bus = buses[i];
                curCount = 0;
                while (hasDonePassengerIndex < passengers.length - 1) {

                    int passenger = passengers[hasDonePassengerIndex + 1];
                    //当前乘客已经上车时间要比公交车晚了
                    if (passenger > bus) {
                        break;
                    }

                    //此乘客上车
                    curCount++;
                    hasDonePassengerIndex++;
                    if (curCount == capacity) {
                        break;
                    }
                }
            }
            if (hasDonePassengerIndex == -1) {
                return buses[buses.length - 1];
            }

            if (curCount < capacity && buses[buses.length - 1] != passengers[hasDonePassengerIndex]) {
                return buses[buses.length - 1];
            }

            int nessGreaterThanIndex = hasDonePassengerIndex;
            while (nessGreaterThanIndex > 0) {
                if (passengers[nessGreaterThanIndex] - 1 != passengers[nessGreaterThanIndex - 1]) {
                    break;
                } else {
                    nessGreaterThanIndex--;
                }
            }
            return passengers[nessGreaterThanIndex] - 1;
        }
}
