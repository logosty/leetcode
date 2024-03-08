package com.logosty.learning.leetcode.section300.part32;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author logosty(ganyingle) on 2021/1/26 16:48
 * 322. 零钱兑换 中等
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Solution322 {

  public static void main(String[] args) {
    int amount = 11;
    int[] ints = {1, 2, 5};
    System.out.println(new Solution322().coinChange(ints, amount));
    System.out.println(new Solution322().coinChangeDp1(ints, amount));
    System.out.println(new Solution322().coinChangeDp2(ints, amount));

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
   */
  public int coinChange1(int[] coins, int amount) {
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


  //region 傻缓存
  //877ms击败5.01%使用 Java 的用户
  private final Map<String, Integer> cache = new HashMap<>();

  public int coinChange(int[] coins, int amount) {
    int process = process(coins, 0, amount);
    return process < 0 ? -1 : process;
  }

  private int process(int[] coins, int coinsIndex, int rest) {
    if (rest == 0) {
      return 0;
    }
    if (rest < 0 || coinsIndex > coins.length - 1) {
      return Integer.MIN_VALUE;
    }
    String key = coinsIndex + "_" + rest;
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    //最后一个，直接求余
    if (coinsIndex == coins.length - 1) {
      if (rest % coins[coinsIndex] != 0) {
        return Integer.MIN_VALUE;
      }
      return rest / coins[coinsIndex];
    }

    //取当前0张
    int r1 = process(coins, coinsIndex + 1, rest);

    //取当前1张
    int r2 = process(coins, coinsIndex, rest - coins[coinsIndex]) + 1;

    int res;
    //比较大小
    if (r1 >= 0 && r2 >= 0) {
      res = Math.min(r1, r2);
    } else if (r1 < 0 && r2 < 0) {
      res = Integer.MIN_VALUE;
    } else {
      res = Math.max(r1, r2);
    }

    cache.put(key, res);
    return res;
  }
  //endregion

  //region dp1
  //25ms击败15.47%使用 Java 的用户
  public int coinChangeDp1(int[] coins, int amount) {
    int dp = dp(coins, amount);
    return dp < 0 ? -1 : dp;
  }

  private int dp(int[] coins, int amount) {
    int coinLength = coins.length;
    int[][] dp = new int[coinLength][amount + 1];

    for (int i = 0; i <= amount; i++) {
      if (i % coins[coinLength - 1] != 0) {
        dp[coinLength - 1][i] = Integer.MIN_VALUE;
      } else {
        dp[coinLength - 1][i] = i / coins[coinLength - 1];
      }
    }

    for (int coinIndex = coinLength - 2; coinIndex >= 0; coinIndex--) {
      for (int rest = 1; rest <= amount; rest++) {

        //取当前0张
        int r1 = coinIndex + 1 >= coinLength ? Integer.MIN_VALUE : dp[coinIndex + 1][rest];
        //取当前1张
        int r2 = rest - coins[coinIndex] < 0 ? Integer.MIN_VALUE : dp[coinIndex][rest - coins[coinIndex]] + 1;

        int res;
        //比较大小
        if (r1 >= 0 && r2 >= 0) {
          res = Math.min(r1, r2);
        } else if (r1 < 0 && r2 < 0) {
          res = Integer.MIN_VALUE;
        } else {
          res = Math.max(r1, r2);
        }

        dp[coinIndex][rest] = res;
      }
    }

    return dp[0][amount];
  }
  //endregion

  //region dp2
  //15ms击败33.62%使用 Java 的用户
  public int coinChangeDp2(int[] coins, int amount) {
    return dp2(coins, amount);
  }
  private int dp2(int[] coins, int amount) {
    Arrays.sort(coins);
    long[] dp = new long[amount + 1];

    for (int i = 1; i <= amount; i++) {
      long min = Integer.MAX_VALUE;
      for (int coin : coins) {
        int rest = i - coin;
        if (rest < 0) {
          break;
        }
        min = Math.min(min, dp[rest] + 1);
      }
      dp[i] = min;
    }

    return dp[amount] >= Integer.MAX_VALUE ? -1 : (int) dp[amount];
  }
}
