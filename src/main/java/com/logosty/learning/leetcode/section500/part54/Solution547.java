package com.logosty.learning.leetcode.section500.part54;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author logosty(ganyingle) on 2021/1/11 16:19
 * 547. 省份数量 中等
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *
 * 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 *
 * 返回矩阵中 省份 的数量。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
 * 输出：2
 * 示例 2：
 *
 *
 * 输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= n <= 200
 * n == isConnected.length
 * n == isConnected[i].length
 * isConnected[i][j] 为 1 或 0
 * isConnected[i][i] == 1
 * isConnected[i][j] == isConnected[j][i]
 */
public class Solution547 {

  public static void main(String[] args) {
//    int[][] ints = {
//        {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
//        {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
//        {0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//        {0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
//        {1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0},
//        {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1},
//        {0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//        {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
//        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1}};

    int[][] ints = new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
    System.out.println(new Solution547().findCircleNum2(ints));

    System.out.println(new Solution547().findCircleNum(ints));

  }

  public int findCircleNum2(int[][] isConnected) {
    boolean[] visited = new boolean[isConnected.length];
    int res = 0;

    for (int i = 0; i < isConnected.length; i++) {
      if (visited[i]) {
        continue;
      }
//      visitedDeep(isConnected, visited, i);
      visitedBreadth(isConnected, visited, i);
      res++;
    }
    return res;
  }

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 99.87%
   * 的用户
   * 内存消耗：
   * 39.6 MB
   * , 在所有 Java 提交中击败了
   * 16.75%
   * 的用户
   */
  private void visitedDeep(int[][] isConnected, boolean[] visited, int i) {
    visited[i] = true;
    for (int j = 0; j < isConnected.length; j++) {
      if (isConnected[i][j] == 0) {
        continue;
      }
      if (visited[j]) {
        continue;
      }
      visitedDeep(isConnected, visited, j);
    }
  }

  /**
   * 执行用时：
   * 9 ms
   * , 在所有 Java 提交中击败了
   * 8.15%
   * 的用户
   * 内存消耗：
   * 39.6 MB
   * , 在所有 Java 提交中击败了
   * 12.96%
   * 的用户
   */
  private void visitedBreadth(int[][] isConnected, boolean[] visited, int i) {
    visited[i] = true;
    List<Integer> toBe = new ArrayList<>(isConnected.length);
    for (int j = 0; j < isConnected.length; j++) {
      if (isConnected[i][j] != 0 && !visited[j]) {
        toBe.add(j);
      }
    }

    for (Integer integer : toBe) {
      visitedBreadth(isConnected, visited, integer);
    }
  }


  /**
   * 执行用时：
   * 8 ms
   * , 在所有 Java 提交中击败了
   * 10.06%
   * 的用户
   * 内存消耗：
   * 39.5 MB
   * , 在所有 Java 提交中击败了
   * 20.61%
   * 的用户
   */
  public int findCircleNum(int[][] isConnected) {
    int[] parent = new int[isConnected.length];

    //init
    for (int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }

    for (int i = 0; i < isConnected.length; i++) {
      for (int j = 0; j < isConnected.length; j++) {
        if (i == j || isConnected[i][j] == 0) {
          continue;
        }
        merge(parent, i, j);
      }
    }
    return (int) IntStream.range(0, isConnected.length)
        .map(i -> findParent(parent, i))
        .distinct()
        .count();

  }

  private int findParent(int[] parent, int i) {
    Integer children = null;
    int cur = i;

    while (parent[cur] != cur) {
      if (children != null) {
        parent[children] = parent[cur];
      }

      children = cur;
      cur = parent[children];
    }
    return parent[cur];
  }

  private void merge(int[] parent, int i, int j) {
    int parentI = findParent(parent, i);
    int parentJ = findParent(parent, j);

    if (parentJ != parentI) {
      parent[parentJ] = i;
    }
  }


}
