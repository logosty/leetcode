package com.logosty.learning.leetcode.section1300.part131;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author logosty(ganyingle) on 2021/1/27 10:55
 * 1319. 连通网络的操作次数 中等
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 * 示例 2：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 * 示例 3：
 *
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 *
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 */
public class Solution1319 {

  /**
   * 执行用时：
   * 20 ms
   * , 在所有 Java 提交中击败了
   * 15.83%
   * 的用户
   * 内存消耗：
   * 53.8 MB
   * , 在所有 Java 提交中击败了
   * 25.91%
   * 的用户
   */
  public int makeConnected1(int n, int[][] connections) {
    if (connections.length < n - 1) {
      return -1;
    }
    UnionFind unionFind = new UnionFind(n);

    for (int[] connection : connections) {
      unionFind.merge(connection[0], connection[1]);
    }

    return (int) (IntStream.range(0, n).map(unionFind::getParent).distinct().count() - 1);
  }

  /**
   * 执行用时：
   * 32 ms
   * , 在所有 Java 提交中击败了
   * 11.69%
   * 的用户
   * 内存消耗：
   * 62.9 MB
   * , 在所有 Java 提交中击败了
   * 5.01%
   * 的用户
   */
  public int makeConnected(int n, int[][] connections) {

    if (connections.length < n - 1) {
      return -1;
    }

    Set<Integer>[] link = new Set[n];
    boolean[] visited = new boolean[n];
    int size = 0;

    for (int[] connection : connections) {
      if (link[connection[0]] == null) {
        link[connection[0]] = new HashSet<>();
      }
      if (link[connection[1]] == null) {
        link[connection[1]] = new HashSet<>();
      }
      link[connection[1]].add(connection[0]);
      link[connection[0]].add(connection[1]);
    }

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }

      loop(visited, link, i);
      size++;
    }
    return size - 1;
  }

  private void loop(boolean[] visited, Set<Integer>[] link, int i) {
    if (visited[i]) {
      return;
    }

    visited[i] = true;
    if (link[i] == null) {
      return;
    }
    for (Integer integer : link[i]) {
      loop(visited, link, integer);
    }
  }

  class UnionFind {

    int[] parent;
    int[] rank;

    public UnionFind(int size) {
      parent = new int[size];
      for (int i = 0; i < size; i++) {
        parent[i] = i;
      }

      rank = new int[size];
      Arrays.fill(rank, 1);
    }

    public void merge(int i, int j) {
      int parentI = getParent(i);
      int parentJ = getParent(j);
      if (parentI == parentJ) {
        return;
      }
      int target = rank[parentI] <= rank[parentJ] ? parentI : parentJ;
      int source = target == parentI ? parentJ : parentI;

      parent[source] = target;
      rank[target] = Math.max(rank[target], rank[source] + 1);
    }

    private int getParent(int i) {
      if (i != parent[i]) {
        parent[i] = getParent(parent[i]);
      }
      return parent[i];
    }
  }
}
