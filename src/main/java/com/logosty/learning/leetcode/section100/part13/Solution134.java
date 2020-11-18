package com.logosty.learning.leetcode.section100.part13;

/**
 * @author logosty(ganyingle) on 2020/11/18 10:29
 * 134. 加油站 中等
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 *
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 *
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 说明:
 *
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 示例 1:
 *
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 *
 * 输出: 3
 *
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 *
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 *
 * 输出: -1
 *
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class Solution134 {

  /**
   * 执行用时：
   * 67 ms
   * , 在所有 Java 提交中击败了
   * 22.80%
   * 的用户
   * 内存消耗：
   * 38.7 MB
   * , 在所有 Java 提交中击败了
   * 80.66%
   * 的用户
   */
  public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas.length < 1) {
      return -1;
    }
    if (gas.length == 1) {
      return gas[0] >= cost[0] ? 0 : -1;
    }
    int[] gap = new int[gas.length];
    for (int i = 0; i < cost.length; i++) {
      gap[i] = gas[i] - cost[i];
    }

    for (int i = 0; i < gap.length; i++) {
      if (gap[i] < 0) {
        continue;
      }

      int last = 0;
      for (int j = 0; j < gap.length; j++) {
        last += gap[(i + j) % gap.length];
        if (last < 0) {
          break;
        }
      }
      if (last >= 0) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(new Solution134().canCompleteCircuit(new int[]{1,2,3,4,5},new int[]{3,4,5,1,2}));
  }
}
