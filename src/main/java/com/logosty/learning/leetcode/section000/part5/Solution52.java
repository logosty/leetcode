package com.logosty.learning.leetcode.section000.part5;

/**
 * @author logosty(ganyingle) on 2020/10/19 11:05
 * 52. N皇后 II 困难
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
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
 *
 *
 * 提示：
 *
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。
 * 当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。
 * 当然，她横、竖、斜都可走一或 N-1 步，可进可退。（引用自 百度百科 - 皇后 ）
 */

/**
 * 执行用时：
 * 1 ms
 * , 在所有 Java 提交中击败了
 * 81.47%
 * 的用户
 * 内存消耗：
 * 35 MB
 * , 在所有 Java 提交中击败了
 * 80.56%
 * 的用户
 */
public class Solution52 {

  private int res = 0;

  public int totalNQueens(int n) {
    int[] ints = new int[n];
    func(ints, 0);

    return res;
  }

  public void func(int[] checkerboard, int column) {
    if (column >= checkerboard.length) {
      res++;
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
    System.out.println(new Solution52().totalNQueens(4));
  }

}

