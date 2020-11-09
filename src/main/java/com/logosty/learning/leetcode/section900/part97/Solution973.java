package com.logosty.learning.leetcode.section900.part97;

import com.alibaba.fastjson.JSON;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author logosty(ganyingle) on 2020/11/9 10:21
 * 973. 最接近原点的 K 个点 中等
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */
public class Solution973 {

  public static void main(String[] args) {
    int[][] ints = {{3, 3}, {5, -1}, {-2, 4}};
    int k = 2;
    System.out.println(JSON.toJSONString(new Solution973().kClosest(ints, k)));
  }

  /**
   * 执行用时：
   * 32 ms
   * , 在所有 Java 提交中击败了
   * 53.92%
   * 的用户
   * 内存消耗：
   * 46.9 MB
   * , 在所有 Java 提交中击败了
   * 74.72%
   * 的用户
   */
  public int[][] kClosest(int[][] points, int K) {
    int[][] cache = new int[points.length][2];

    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(points.length,
        Comparator.comparingInt(o -> o[1]));

    for (int i = 0; i < points.length; i++) {
      int i0 = points[i][0];
      int i1 = points[i][1];
      cache[i][0] = i;
      cache[i][1] = i0 * i0 + i1 * i1;

      priorityQueue.offer(cache[i]);
    }

    int[][] res = new int[K][2];
    for (int i = 0; i < K; i++) {
      int[] poll = priorityQueue.poll();

      res[i] = points[poll[0]];
    }
    return res;
  }
}
