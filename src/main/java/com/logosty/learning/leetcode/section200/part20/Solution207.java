package com.logosty.learning.leetcode.section200.part20;

import java.util.ArrayList;

/**
 * @author logosty(ganyingle) on 2021/1/19 15:19
 * 207. 课程表 中等
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 */
public class Solution207 {
    boolean ret = true;
    int[] visited;
    ArrayList<Integer>[] linked;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        linked = new ArrayList[numCourses];
        visited = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            if (linked[from] == null) {
                linked[from] = new ArrayList<>();
            }

            linked[from].add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            dfs(i);
        }

        return ret;
    }

    private void dfs(int i) {
        ArrayList<Integer> list = linked[i];
        if (list == null || visited[i] == 1 || !ret) {
            return;
        }
        if (visited[i] == -1) {
            ret = false;
            return;
        }

        //将该值标成处理中
        visited[i] = -1;
        for (int to : list) {
            dfs(to);
        }
        visited[i] = 1;
    }

}
