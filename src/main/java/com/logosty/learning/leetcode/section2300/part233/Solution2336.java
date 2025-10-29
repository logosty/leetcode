package com.logosty.learning.leetcode.section2300.part233;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2025/10/29 14:55
 * description: 2336. 无限集中的最小数字 中等
 * 现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
 * <p>
 * 实现 SmallestInfiniteSet 类：
 * <p>
 * SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
 * int popSmallest() 移除 并返回该无限集中的最小整数。
 * void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集中。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["SmallestInfiniteSet", "addBack", "popSmallest", "popSmallest", "popSmallest", "addBack", "popSmallest",
 * "popSmallest", "popSmallest"]
 * [[], [2], [], [], [], [1], [], [], []]
 * 输出
 * [null, null, 1, 2, 3, null, 1, 4, 5]
 * <p>
 * 解释
 * SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
 * smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
 * smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 2 ，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 3 ，并将其从集合中移除。
 * smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
 * smallestInfiniteSet.popSmallest(); // 返回 1 ，因为 1 在上一步中被添加到集合中，
 * // 且 1 是最小的整数，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 4 ，并将其从集合中移除。
 * smallestInfiniteSet.popSmallest(); // 返回 5 ，并将其从集合中移除。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 1000
 * 最多调用 popSmallest 和 addBack 方法 共计 1000 次
 */
public class Solution2336 {
}


/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
class SmallestInfiniteSet {
    //已经删除的数组
    Set<Integer> deletedSet = new HashSet<>();

    int[] minHeap;
    int heapSize;
    //    int curMaxNum;

    public SmallestInfiniteSet() {
        minHeap = new int[1001];
        for (int i = 0; i < 1000; i++) {
            minHeap[i] = i + 1;
        }
        //        curMaxNum = 1000;
        heapSize = 1000;
    }

    public int popSmallest() {
        int result = minHeap[0];
        minHeap[0] = minHeap[heapSize - 1];
        heapSize--;
        filterDown(0);
        deletedSet.add(result);

        //填充一个数进来
        //        minHeap[heapSize++] = curMaxNum++;

        return result;
    }

    public void addBack(int num) {
        if (!deletedSet.contains(num)) {
            return;
        }
        minHeap[heapSize] = num;
        filterUp(heapSize);
        heapSize++;
        deletedSet.remove(num);
    }

    //向上调整
    private void filterUp(int index) {
        if (index == 0) {
            return;
        }

        int father = (index - 1) / 2;
        if (minHeap[father] > minHeap[index]) {
            int cur = minHeap[index];
            minHeap[index] = minHeap[father];
            minHeap[father] = cur;
            filterUp(father);
        }
    }

    //向下调整
    private void filterDown(int index) {
        int left = 2 * index + 1;
        int right = left + 1;

        //左孩子已经超额，直接返回
        if (left > heapSize - 1) {
            return;
        }

        //挑选左右阶段中更小的一个互换
        int minChild = left;
        if (right <= heapSize - 1) {
            minChild = minHeap[right] < minHeap[left] ? right : left;
        }

        if (minHeap[minChild] < minHeap[index]) {
            int tmp = minHeap[minChild];
            minHeap[minChild] = minHeap[index];
            minHeap[index] = tmp;
            filterDown(minChild);
        }
    }
}