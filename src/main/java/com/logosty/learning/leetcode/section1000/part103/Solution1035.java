package com.logosty.learning.leetcode.section1000.part103;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/8/10 17:08
 * 1035. 不相交的线 中等
 * 我们在两条独立的水平线上按给定的顺序写下 A 和 B 中的整数。
 *
 * 现在，我们可以绘制一些连接两个数字 A[i] 和 B[j] 的直线，只要 A[i] == B[j]，且我们绘制的直线不与任何其他连线（非水平线）相交。
 *
 * 以这种方法绘制线条，并返回我们可以绘制的最大连线数。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：A = [1,4,2], B = [1,2,4]
 * 输出：2
 * 解释：
 * 我们可以画出两条不交叉的线，如上图所示。
 * 我们无法画出第三条不相交的直线，因为从 A[1]=4 到 B[2]=4 的直线将与从 A[2]=2 到 B[1]=2 的直线相交。
 * 示例 2：
 *
 * 输入：A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * 输出：3
 * 示例 3：
 *
 * 输入：A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * 输出：2
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 500
 * 1 <= B.length <= 500
 * 1 <= A[i], B[i] <= 2000
 */
public class Solution1035 {

  Map<String, Integer> cache = new HashMap<>();

  public int maxUncrossedLines(int[] A, int[] B) {
    if (A.length == 0 || B.length == 0) {
      return 0;
    }

    return maxUncrossedLines(A, B, 0, 0);
  }

  public int maxUncrossedLines(int[] A, int[] B, int offsetA, int offsetB) {
    String cacheKey = offsetA + ":" + offsetB;
    if (cache.containsKey(cacheKey)) {
      return cache.get(cacheKey);
    }
    if (offsetA == A.length || offsetB == B.length) {
      return 0;
    }
    int i1 = maxUncrossedLines(A, B, offsetA + 1, offsetB);
    for (int i = offsetB; i < B.length; i++) {
      if (B[i] == A[offsetA]) {
        int max = Math.max(1 + maxUncrossedLines(A, B, offsetA + 1, i + 1), i1);
        cache.put(cacheKey, max);
        return max;
      }
    }
    cache.put(cacheKey, i1);
    return i1;
  }

  public static void main(String[] args) {
    int[] int1 = {1,3,7,1,7,5};
    int[] int2 = {1,9,2,5,1};
    System.out.println(new Solution1035().maxUncrossedLines(int1, int2));

  }
}
