package com.logosty.learning.leetcode.section1000.part104;

/**
 * @author logosty(ganyingle) on 2020/12/30 11:33
 * 1046. 最后一块石头的重量 简单
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 *
 * 示例：
 *
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 *
 *
 * 提示：
 *
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 1000
 */
public class Solution1046 {

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 80.11%
   * 的用户
   * 内存消耗：
   * 35.8 MB
   * , 在所有 Java 提交中击败了
   * 64.32%
   * 的用户
   */
  public int lastStoneWeight(int[] stones) {
    int first = -1, second = -1;

    for (int i = 0; i < stones.length; i++) {
      first = Math.max(stones[i], first);
    }

    int[] cache = new int[first + 1];

    for (int i = 0; i < stones.length; i++) {
      cache[stones[i]]++;
    }

    while (first > 0) {
      second = -1;
      cache[first] &= 1;
      if (cache[first] == 0) {
        first--;
        continue;
      }

      for (int i = first - 1; i > 0; i--) {
        if (cache[i] != 0) {
          second = i;
          break;
        }
      }

      if (second < 0) {
        break;
      }

      cache[first - second]++;
      cache[first]--;
      cache[second]--;
      first = Math.max(second, first - second);
    }
    return first;
  }

  public static void main(String[] args) {
    System.out.println(new Solution1046().lastStoneWeight(new int[]{2,7,4,1,8,1}));
  }
}
