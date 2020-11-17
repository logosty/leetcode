package com.logosty.learning.leetcode.section1000.part103;

import com.alibaba.fastjson.JSON;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author logosty(ganyingle) on 2020/11/17 10:19
 * 1030. 距离顺序排列矩阵单元格 简单
 * 给出 R 行 C 列的矩阵，其中的单元格的整数坐标为 (r, c)，满足 0 <= r < R 且 0 <= c < C。
 *
 * 另外，我们在该矩阵中给出了一个坐标为 (r0, c0) 的单元格。
 *
 * 返回矩阵中的所有单元格的坐标，并按到 (r0, c0) 的距离从最小到最大的顺序排，其中，两单元格(r1, c1) 和 (r2, c2) 之间的距离是曼哈顿距离，|r1 - r2| + |c1 - c2|。（你可以按任何满足此条件的顺序返回答案。）
 *
 *
 *
 * 示例 1：
 *
 * 输入：R = 1, C = 2, r0 = 0, c0 = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * 示例 2：
 *
 * 输入：R = 2, C = 2, r0 = 0, c0 = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * 示例 3：
 *
 * 输入：R = 2, C = 3, r0 = 1, c0 = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 *
 *
 * 提示：
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */
public class Solution1030 {

  private boolean[][] visited;
  private int[][] res;

  public static void main(String[] args) {
    System.out.println(JSON.toJSONString(new Solution1030().allCellsDistOrder(1, 2, 0, 0)));
  }

  /**
   * 执行用时：
   * 7 ms
   * , 在所有 Java 提交中击败了
   * 93.98%
   * 的用户
   * 内存消耗：
   * 40.2 MB
   * , 在所有 Java 提交中击败了
   * 98.62%
   * 的用户
   */
  public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
    visited = new boolean[R][C];
    res = new int[R * C][2];
    ArrayDeque<Pair> deque = new ArrayDeque<>();
    deque.add(new Pair(r0, c0));
    loop(deque, 0);
    return res;
  }

  private void loop(Deque<Pair> next, int offset) {
    int size = next.size();
    if (size == 0) {
      return;
    }
    for (int i = 0; i < size; i++) {
      Pair pair = next.pollFirst();

      int r = pair.key;
      int c = pair.value;

      if ( r < 0 || c < 0 || r >= visited.length || c >= visited[0].length || visited[r][c]) {
        continue;
      }
      res[offset][0] = r;
      res[offset][1] = c;
      offset++;

      visited[r][c] = true;

      next.add(new Pair(r, c + 1));
      next.add(new Pair(r + 1, c));
      next.add(new Pair(r, c - 1));
      next.add(new Pair(r - 1, c));
    }
    loop(next, offset);
  }

  class Pair {

    int key;
    int value;

    public Pair(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }
}
