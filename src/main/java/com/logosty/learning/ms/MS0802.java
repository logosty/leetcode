package com.logosty.learning.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/11/12 20:06
 * 面试题 08.02. 迷路的机器人 中等
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * 说明：r 和 c 的值均不超过 100。
 */
public class MS0802 {

  private boolean stop;
  private int step = 0;
  private boolean[][] visited;

  public static void main(String[] args) {
    int[][] ints = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
    System.out.println(new MS0802().pathWithObstacles(ints));
  }

  /**
   * 执行用时：
   * 1 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 40 MB
   * , 在所有 Java 提交中击败了
   * 29.62%
   * 的用户
   */
  public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return Collections.emptyList();
    }

    visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
    boolean[] cache = new boolean[obstacleGrid.length + obstacleGrid[0].length];
    loop(obstacleGrid, cache, 0, 0, 0);

    List<List<Integer>> res = new ArrayList<>();
    if (!stop) {
      return res;
    }

    res.add(List.of(0, 0));
    int x = 0, y = 0;
    for (int i = 0; i < Math.min(step, cache.length); i++) {
      if (cache[i]) {
        x++;
      } else {
        y++;
      }
      res.add(List.of(y, x));
    }

    return res;
  }

  private void loop(int[][] obstacleGrid, boolean[] cache, int cacheIndex, int y, int x) {
    if (visited[y][x] || stop || obstacleGrid[y][x] == 1) {
      return;
    }
    visited[y][x] = true;
    if (y == obstacleGrid.length - 1 && x == obstacleGrid[0].length - 1) {
      stop = true;
      step = cacheIndex;
      return;
    }
    //left
    if (x != obstacleGrid[0].length - 1) {
      cache[cacheIndex] = true;
      loop(obstacleGrid, cache, cacheIndex + 1, y, x + 1);
    }
    if (stop) {
      return;
    }
    //down
    if (y != obstacleGrid.length - 1) {
      cache[cacheIndex] = false;
      loop(obstacleGrid, cache, cacheIndex + 1, y + 1, x);
    }
  }
}
