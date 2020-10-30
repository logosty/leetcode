package com.logosty.learning.leetcode.section400.part46;

/**
 * @author logosty(ganyingle) on 2020/10/30 10:10
 * 463. 岛屿的周长 简单
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 *
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 *
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 *
 *
 *
 * 示例 :
 *
 * 输入:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * 输出: 16
 *
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class Solution463 {

  /**
   * 执行用时：
   * 8 ms
   * , 在所有 Java 提交中击败了
   * 75.57%
   * 的用户
   * 内存消耗：
   * 40.1 MB
   * , 在所有 Java 提交中击败了
   * 14.57%
   * 的用户
   */
  public int islandPerimeter(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int total = 0;
    int connected = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          total++;
          connected += isConnected(grid, i, j);
        }
      }
    }

    return total * 4 - connected * 2;

  }

  private int isConnected(int[][] grid, int x, int y) {
    int res = 0;
    if (x > 0 && grid[x - 1][y] == 1) {
      res++;
    }
    if (y > 0 && grid[x][y - 1] == 1) {
      res++;
    }
    return res;
  }
}
