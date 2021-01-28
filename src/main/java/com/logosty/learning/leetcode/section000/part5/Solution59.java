package com.logosty.learning.leetcode.section000.part5;

import com.alibaba.fastjson.JSON;

/**
 * @author logosty(ganyingle) on 2021/1/28 10:51
 * 59. 螺旋矩阵 II 中等
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class Solution59 {

  /**
   * 执行用时：
   * 0 ms
   * , 在所有 Java 提交中击败了
   * 100.00%
   * 的用户
   * 内存消耗：
   * 36.5 MB
   * , 在所有 Java 提交中击败了
   * 63.88%
   * 的用户
   */
  public int[][] generateMatrix(int n) {
    int offset = 1;
    int flag = 1;  // 1:->  2:下 3:<- 4:^
    int x = 0;
    int y = 0;

    int[][] res = new int[n][n];

    while (offset <= n * n) {
      res[x][y] = offset++;

      switch (flag) {
        case 1:
          if (y == n - 1 || res[x][y + 1] != 0) {
            flag = 2;
            x++;
          } else {
            y++;
          }
          break;
        case 2:
          if (x == n - 1 || res[x + 1][y] != 0) {
            flag = 3;
            y--;
          } else {
            x++;
          }
          break;
        case 3:
          if (y == 0 || res[x][y - 1] != 0) {
            flag = 4;
            x--;
          } else {
            y--;
          }
          break;
        case 4:
          if (x == 0 || res[x - 1][y] != 0) {
            flag = 1;
            y++;
          } else {
            x--;
          }
          break;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(JSON.toJSONString(new Solution59().generateMatrix(3)));
  }
}
