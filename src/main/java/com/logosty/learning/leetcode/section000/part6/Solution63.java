package com.logosty.learning.leetcode.section000.part6;

import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/7/6 10:15
 * 63. 不同路径 II 中等
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Solution63 {

  private Map<String, Integer> cache;

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    cache = new HashMap<>();
    if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
      return 0;
    }
    return get(obstacleGrid, 0, 0);
  }

  public int get(int[][] obstacleGrid, int x, int y) {
    String key = x + "_" + y;
    if (cache.get(key) != null) {
      return cache.get(key);
    }

    int xLength = obstacleGrid.length;
    int yLength = obstacleGrid[0].length;
    if (x == xLength || y == yLength) {
      cache.put(key, 0);
      return 0;
    }
    if (obstacleGrid[x][y] == 1) {
      cache.put(key, 0);
      return 0;
    }

    int ret = 0;
    if (x == xLength - 1 && y == yLength - 1) {
      cache.put(key, 1);
      return 1;
    } else if (x == xLength - 1) {
      ret = get(obstacleGrid, x, y + 1);
      cache.put(key, ret);
      return ret;
    } else if (y == yLength - 1) {
      ret = get(obstacleGrid, x + 1, y);
      cache.put(key, ret);
      return ret;
    }

    ret = get(obstacleGrid, x + 1, y) + get(obstacleGrid, x, y + 1);
    cache.put(key, ret);
    return ret;
  }

}
