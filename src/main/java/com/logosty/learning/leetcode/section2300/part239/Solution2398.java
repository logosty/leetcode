package com.logosty.learning.leetcode.section2300.part239;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2024/9/13 15:17
 * description: 2398. 预算内的最多机器人数目 困难
 * 你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。第 i 个机器人充电时间为 chargeTimes[i] 单位时间，花费
 * runningCosts[i] 单位时间运行。再给你一个整数 budget 。
 * <p>
 * 运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，其中 max(chargeTimes) 是这 k 个机器人中最大充电时间，sum(runningCosts)
 * 是这 k 个机器人的运行时间之和。
 * <p>
 * 请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
 * 输出：3
 * 解释：
 * 可以在 budget 以内运行所有单个机器人或者连续运行 2 个机器人。
 * 选择前 3 个机器人，可以得到答案最大值 3 。总开销是 max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 ，小于 25 。
 * 可以看出无法在 budget 以内连续运行超过 3 个机器人，所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
 * 输出：0
 * 解释：即使运行任何一个单个机器人，还是会超出 budget，所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * chargeTimes.length == runningCosts.length == n
 * 1 <= n <= 5 * 104
 * 1 <= chargeTimes[i], runningCosts[i] <= 105
 * 1 <= budget <= 1015
 */
public class Solution2398 {
    int res = 0;

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int length = chargeTimes.length;

        int left = 0;
        long sumRunningCosts = 0;
        MaxHeapWithCount heap = new MaxHeapWithCount(length);

        for (int right = 0; right < length; right++) {
            long chargeTime = chargeTimes[right];
            long runningCost = runningCosts[right];

            sumRunningCosts += runningCost;
            long maxChargeTime = heap.insert((int) chargeTime);

            boolean canDo = canDo(budget, maxChargeTime, sumRunningCosts, right - left + 1);

            while (!canDo && left <= right) {
                maxChargeTime = heap.remove(chargeTimes[left]);
                sumRunningCosts -= runningCosts[left];

                left++;
                canDo = canDo(budget, maxChargeTime, sumRunningCosts, right - left + 1);
            }
        }

        return res;
    }

    private boolean canDo(long budget, long maxChargeTime, long sumRunningCosts, int count) {
        if (count == 0) {
            return true;
        }

        long sumBudget = maxChargeTime + count * sumRunningCosts;
        boolean canDo = budget >= sumBudget;
        if (canDo) {
            res = Math.max(res, count);
        }
        return canDo;
    }


    static class MaxHeapWithCount {
        //数值对应的数量
        Map<Integer, Integer> valueCountMap = new HashMap<>();

        // 数值对应的index
        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        int[] heapStorage;
        int curHeapSize = 0;

        public MaxHeapWithCount(int maxSize) {
            heapStorage = new int[maxSize];
        }

        public int insert(int value) {
            if (valueCountMap.containsKey(value)) {
                valueCountMap.put(value, valueCountMap.get(value) + 1);
                return getMaxValue();
            }

            valueCountMap.put(value, 1);
            heapStorage[curHeapSize] = value;
            valueIndexMap.put(value, curHeapSize);
            up(curHeapSize);

            curHeapSize++;
            return getMaxValue();
        }

        public int remove(int value) {
            int count = valueCountMap.getOrDefault(value, 0);
            if (count > 1) {
                valueCountMap.put(value, count - 1);
                return getMaxValue();
            }

            //仅有一个该数值
            valueCountMap.remove(value);
            int index = valueIndexMap.get(value);

            removeNode(index);
            return getMaxValue();
        }

        public int getMaxValue() {
            return curHeapSize == 0 ? 0 : heapStorage[0];
        }

        /**
         * 删除某个节点
         */
        private void removeNode(int index) {

            int value = heapStorage[index];
            exchange(index, curHeapSize - 1);
            curHeapSize--;
            valueIndexMap.remove(value);

            up(index);
            down(index);
        }

        private void exchange(int index1, int index2) {
            if (index1 == index2) {
                return;
            }

            int value1 = heapStorage[index1];
            int value2 = heapStorage[index2];

            heapStorage[index1] = value2;
            heapStorage[index2] = value1;

            valueIndexMap.put(value1, index2);
            valueIndexMap.put(value2, index1);
        }

        /**
         * 从某个节点开始往前整理
         */
        private void up(int index) {
            if (index == 0) {
                return;
            }
            int fatherIndex = (index - 1) / 2;
            if (heapStorage[fatherIndex] < heapStorage[index]) {
                exchange(index, fatherIndex);
                up(fatherIndex);
            }
        }

        private void down(int index) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            //已经没有左子树
            if (left >= curHeapSize) {
                return;
            }

            int maxIndex = left;
            if (right < curHeapSize && heapStorage[left] < heapStorage[right]) {
                maxIndex = right;
            }

            if (heapStorage[maxIndex] > heapStorage[index]) {
                exchange(index, maxIndex);
                down(maxIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = {19,63,21,8,5,46,56,45,54,30,92,63,31,71,87,94,67,8,19,89,79,25};
        int[] ints1 = {91,92,39,89,62,81,33,99,28,99,86,19,5,6,19,94,65,86,17,10,8,42};
        long l = 85;
        System.out.println(new Solution2398().maximumRobots(ints,ints1,l));
    }
}
