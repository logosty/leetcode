package com.logosty.learning.leetcode.section000.part5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/10/20 15:00
 * 51. N 皇后 困难
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 *
 * 示例：
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 *
 * 提示：
 *
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 */
public class Solution51 {

  List<List<String>> res = new ArrayList<>();
  String strTemplate;


  public List<List<String>> solveNQueens(int n) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(".");
    }
    strTemplate = sb.toString();

    func(new int[n], 0);
    return res;
  }


  public void func(int[] checkerboard, int column) {
    if (column >= checkerboard.length) {
      res.add(buildRes(checkerboard));
      return;
    }

    for (int i = 0; i < checkerboard.length; i++) {
      if (!check(checkerboard, column, i)) {
        continue;
      }

      checkerboard[column] = i;
      func(checkerboard, column + 1);
    }
  }

  private List<String> buildRes(int[] checkerboard) {

    List<String> res = new ArrayList<>();
    for (int i = 0; i < checkerboard.length; i++) {
      res.add(strTemplate);
    }

    for (int i = 0; i < checkerboard.length; i++) {
      String s = res.get(i);
      String s1 =
          s.substring(0, checkerboard[i]) + "Q" + s.substring(checkerboard[i] + 1, s.length());
      res.set(i, s1);
    }
    return res;
  }

  private boolean check(int[] checkerboard, int column, int row) {
    for (int i = 1; column - i >= 0; i++) {
      if (checkerboard[column - i] == row || checkerboard[column - i] == row + i
          || checkerboard[column - i] == row - i) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(new Solution51().solveNQueens(4));
  }
}
