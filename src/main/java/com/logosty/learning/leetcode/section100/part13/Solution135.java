package com.logosty.learning.leetcode.section100.part13;

import java.util.stream.IntStream;

/**
 * @author logosty(ganyingle) on 2020/12/24 10:08
 * 135. 分发糖果 困难
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 * 示例 1:
 *
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 *
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 */
public class Solution135 {

  public static void main(String[] args) {
    System.out.println(new Solution135().candy(new int[]{1, 0, 2}));
  }

  public int candy(int[] ratings) {
    int lastTop = 0;
    Integer nextTop = 0;
    int low = 0;

    for (int i = 0; i < ratings.length; i++) {



    }
    return 0;
  }

  /**
   * 执行用时：
   * 548 ms
   * , 在所有 Java 提交中击败了
   * 8.18%
   * 的用户
   * 内存消耗：
   * 39.3 MB
   * , 在所有 Java 提交中击败了
   * 89.74%
   * 的用户
   */
  public int candy1(int[] ratings) {
    if (ratings.length == 0) {
      return 0;
    }
    if (ratings.length == 1) {
      return 1;
    }

    int[] cache = new int[ratings.length];

    cache[0] = 1;
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        cache[i] = cache[i - 1] + 1;
        continue;
      }

      cache[i] = 1;

      int j = i;
      while (j >= 1 && ratings[j - 1] > ratings[j] && cache[j] >= cache[j - 1]) {
        cache[j - 1]++;
        j--;
      }
    }
    return IntStream.of(cache).sum();
  }
}
