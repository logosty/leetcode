package com.logosty.learning.leetcode.section1500.part158;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2021/1/19 11:15
 * 1584. 连接所有点的最小费用 中等
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * 所有点 (xi, yi) 两两不同。
 */
public class Solution1584 {

  public static void main(String[] args) {
    int[][] ints = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
    System.out.println(new Solution1584().minCostConnectPoints(ints));
  }

  /**
   * 执行用时：
   * 829 ms
   * , 在所有 Java 提交中击败了
   * 13.94%
   * 的用户
   * 内存消耗：
   * 60.8 MB
   * , 在所有 Java 提交中击败了
   * 29.54%
   * 的用户
   * @param points
   * @return
   */
  public int minCostConnectPoints(int[][] points) {
    List<Side> sides = new ArrayList<>();
    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        sides.add(new Side(i, j,
            Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
      }
    }

    sides.sort(Comparator.comparing(side -> side.len));

    UnionFind unionFind = new UnionFind(points.length);

    for (Side side : sides) {
      int merge = unionFind.merge(side.left, side.right, side.len);
      if (merge != -1) {
        return merge;
      }
    }
    return 0;
  }

  static class Side {

    int left;
    int right;
    int len;

    public Side(int left, int right, int len) {
      this.left = left;
      this.right = right;
      this.len = len;
    }
  }

  static class UnionFind {

    int[] parent;
    int[] rank;
    int[] size;
    int[] length;

    public UnionFind(int len) {
      parent = new int[len];
      for (int i = 0; i < parent.length; i++) {
        parent[i] = i;
      }

      rank = new int[len];
      Arrays.fill(rank, 1);

      length = new int[len];

      size = new int[len];
      Arrays.fill(size, 1);
    }

    public int merge(int i, int j, int len) {
      int parentI = findParent(i);
      int parentJ = findParent(j);
      if (parentI == parentJ) {
        return -1;
      }
      int target = rank[parentI] >= rank[parentJ] ? parentI : parentJ;
      int origin = target == parentI ? parentJ : parentI;

      parent[origin] = target;

      rank[target] = Math.max(rank[target], rank[origin] + 1);
      size[target] += size[origin];
      length[target] += (length[origin] + len);

      if (size[target] == parent.length) {
        return length[target];
      }
      return -1;
    }

    private int findParent(int i) {
      if (i != parent[i]) {
        parent[i] = findParent(parent[i]);
      }
      return parent[i];
    }
  }

}
