package com.logosty.learning.leetcode.section1200.part128;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * @author logosty(ganyingle) on 2021/1/26 10:14
 * 1128. 等价多米诺骨牌对的数量 简单
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 *
 *
 * 示例：
 *
 * 输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 */
public class Solution1288 {

  public static <T, R> R cal(T a, T b, BiPredicate<T, T> biPredicate,
      BiFunction<T, T, R> biFunction) {
    if (biPredicate.test(a, b)) {
      return biFunction.apply(a, b);
    } else {
      return biFunction.apply(b, a);
    }
  }

  public int numEquivDominoPairs(int[][] dominoes) {
    int res = 0;
    int[] nums = new int[100];

    BiPredicate<Integer, Integer> predicate = (i, j) -> i <= j;
    BiFunction<Integer, Integer, Integer> biFunction = (i, j) -> i * 10 + j;

    for (int[] dominoe : dominoes) {
      Integer cal = cal(dominoe[0], dominoe[1], predicate, biFunction);
      res += nums[cal];
      nums[cal]++;
    }
    return res;
  }
}
