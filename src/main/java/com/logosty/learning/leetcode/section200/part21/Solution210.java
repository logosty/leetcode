package com.logosty.learning.leetcode.section200.part21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2021/1/19 16:06
 * 210. 课程表 II 中等
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 *
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 *
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 *
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 *      因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 说明:
 *
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 提示:
 *
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 拓扑排序也可以通过 BFS 完成。
 */
public class Solution210 {

  Set<Integer> top = new HashSet<>();
  List<Integer>[] lists;
  int[] visited;
  boolean valid = true;
  int[] res;
  int offset;

  public static void main(String[] args) {
//    System.out.println(Arrays
//        .toString(new Solution210().findOrder(8, new int[][]{{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}})));
    System.out.println(Arrays
        .toString(new Solution210().findOrder(2, new int[][]{{1,0}})));
  }

  /**
   * 执行用时：
   * 6 ms
   * , 在所有 Java 提交中击败了
   * 62.95%
   * 的用户
   * 内存消耗：
   * 39.8 MB
   * , 在所有 Java 提交中击败了
   * 31.18%
   * 的用户
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    lists = new List[numCourses];
    visited = new int[numCourses];
    res = new int[numCourses];
    offset = res.length - 1;

    for (int i = 0; i < numCourses; i++) {
      lists[i] = new ArrayList();
      top.add(i);
    }

    for (int[] prerequisite : prerequisites) {
      lists[prerequisite[1]].add(prerequisite[0]);
      top.remove(prerequisite[0]);
    }

    if (top.size() == 0) {
      return new int[0];
    }
    for (Integer integer : top) {
      dfs(integer);
      if (!valid) {
        return new int[0];
      }
    }

    return offset < 0 ? res : new int[0];
  }

  private void dfs(int i) {
    if (visited[i] == 1) {
      return;
    }
    if (visited[i] == -1) {
      valid = false;
      return;
    }
    visited[i] = -1;

    for (int j = 0; j < lists[i].size() && valid; j++) {
      dfs(lists[i].get(j));
    }

    visited[i] = 1;
    res[offset--] = i;
  }
}
