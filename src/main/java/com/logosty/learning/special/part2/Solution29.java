package com.logosty.learning.special.part2;

import com.alibaba.fastjson.JSON;
import com.logosty.learning.util.ArrayUtils;

/**
 * @author logosty(ganyingle) on 2020/6/5 10:42
 * 面试题29. 顺时针打印矩阵 简单
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 */
public class Solution29 {


  public int[] spiralOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[0];
    }
    if (matrix.length == 1) {
      return matrix[0];
    }
    if (matrix[0].length == 1) {
      int[] ret = new int[matrix.length];
      for (int i = 0; i < matrix.length; i++) {
        ret[i] = matrix[i][0];
      }
      return ret;
    }


    int[] ret = new int[matrix.length * matrix[0].length];

    Border border = new Border(-1, matrix.length, -2, matrix[0].length);

    right(border, matrix, 0, 0, ret, 0);

    return ret;
  }

  public void up(Border border, int[][] matrix, int x, int y, int[] ret, int pos) {
    border.down--;
    boolean end = true;

    for (; x > border.up+1; x--) {
      ret[pos] = matrix[x][y];
      pos++;
      end = false;

    }

    if (end) {
      ret[pos] = matrix[x][y];

      return;
    }

    right(border, matrix, x, y, ret, pos);
  }

  public void down(Border border, int[][] matrix, int x, int y, int[] ret, int pos) {
    border.up++;
    boolean end = true;

    for (; x < border.down-1; x++) {
      ret[pos] = matrix[x][y];
      pos++;
      end = false;

    }

    if (end) {
      ret[pos] = matrix[x][y];

      return;
    }
    left(border, matrix, x, y, ret, pos);
  }

  public void left(Border border, int[][] matrix, int x, int y, int[] ret, int pos) {
    border.right--;
    boolean end = true;

    for (; y > border.left+1; y--) {
      ret[pos] = matrix[x][y];
      pos++;
      end = false;
    }

    if (end) {
      ret[pos] = matrix[x][y];
      return;
    }
    up(border, matrix, x, y, ret, pos);
  }

  public void right(Border border, int[][] matrix, int x, int y, int[] ret, int pos) {
    border.left++;
    boolean end = true;

    for (; y < border.right-1; y++) {
      ret[pos] = matrix[x][y];
      pos++;
      end = false;
    }

    if (end) {
      ret[pos] = matrix[x][y];
      return;
    }
    down(border, matrix, x, y, ret, pos);

  }

  class Border {

    public int up;
    public int down;
    public int left;
    public int right;

    public Border() {
    }

    public Border(int up, int down, int left, int right) {
      this.up = up;
      this.down = down;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
//    String input = "[[1,2,3],[4,5,6],[7,8,9]]";
        String input = "[[3],[2]]";

    int[][] ints = ArrayUtils.stringToInt2dArray(input);

    System.out.println(JSON.toJSONString(new Solution29().spiralOrder(ints)));

  }
}
