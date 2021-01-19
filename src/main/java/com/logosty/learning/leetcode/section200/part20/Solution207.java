package com.logosty.learning.leetcode.section200.part20;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2021/1/19 15:19
 * 207. 课程表 中等
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 *
 * 提示：
 *
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class Solution207 {

  int[] visited;
  List<Integer>[] lists;
  boolean valid = true;

  public static void main(String[] args) {
    System.out.println(new Solution207().canFinish(2, new int[][]{ {1, 0}}));
  }

  /**
   * 执行用时：
   * 2 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 38.9 MB
   * , 在所有 Java 提交中击败了
   * 74.58%
   * 的用户
   * @param numCourses
   * @param prerequisites
   * @return
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    lists = new List[numCourses];
    visited = new int[numCourses];
    for (int i = 0; i < lists.length; i++) {
      lists[i] = new ArrayList<>();
    }

    for (int[] prerequisite : prerequisites) {
      lists[prerequisite[1]].add(prerequisite[0]);
    }

    for (int i = 0; i < numCourses; i++) {
      if (visited[i] == 0) {
        dfs(i);
      }
    }
    return valid;
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
  }

}
