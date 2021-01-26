package com.logosty.learning.leetcode.section300.part32;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author logosty(ganyingle) on 2021/1/26 16:48
 * 322. 零钱兑换 中等
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Solution322 {


  public static void main(String[] args) {
    System.out.println(new Solution322().coinChange(new int[]{1, 2}, 2));
  }

  /**
   * 执行用时：
   * 128 ms
   * , 在所有 Java 提交中击败了
   * 6.26%
   * 的用户
   * 内存消耗：
   * 39.3 MB
   * , 在所有 Java 提交中击败了
   * 5.02%
   * 的用户
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int res = 1;
    Set<Integer> visited = new HashSet<>();

    Set<Integer> survived = Arrays.stream(coins).filter(value -> value <= amount).boxed()
        .collect(Collectors.toSet());
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    for (int anInt : survived) {
      if (amount == anInt) {
        return 1;
      }
      deque.add(anInt);
    }

    while (!deque.isEmpty()) {
      int size = deque.size();

      for (int i = 0; i < size; i++) {
        Integer first = deque.pollFirst();
        if (first == amount) {
          return res;
        }

        for (Integer anInt : survived) {

          int i1 = first + anInt;
          if (visited.contains(i1)) {
            continue;
          }
          if (i1 == amount) {
            return res + 1;
          }
          if (i1 < amount) {
            deque.addLast(i1);
            visited.add(i1);
          }
        }
      }
      res++;
    }

    return -1;
  }


}
