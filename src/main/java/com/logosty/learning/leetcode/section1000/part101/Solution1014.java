package com.logosty.learning.leetcode.section1000.part101;

/**
 * @author logosty(ganyingle) on 2020/6/17 16:00
 * 1014. 最佳观光组合 中等
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 *
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 *
 * 返回一对观光景点能取得的最高分。
 *
 *
 *
 * 示例：
 *
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 */
public class Solution1014 {
  public int maxScoreSightseeingPair(int[] values) {
    int maxLast = values[0];
    int maxRet = 0;

    for (int i = 1; i < values.length; i++) {
      maxRet = Math.max(maxRet, values[i] - i + maxLast);
      maxLast = Math.max(maxLast, values[i] + i);
    }
    return maxRet;
  }

  public static void main(String[] args) {

  }
}
