package com.logosty.learning.leetcode.section000.part7;

/**
 * @author logosty(ganyingle) on 2024/3/8 15:41
 * 79 单词搜索 中等
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * <p>
 * <p>
 * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] hasUsed = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, 0, hasUsed, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 147
     * ms
     * 击败
     * 56.20%
     * 使用 Java 的用户
     */
    private boolean search(char[][] board, String word, int wordIndex, boolean[][] hasUsed, int curX, int curY) {
        if (wordIndex >= word.length()) {
            return true;
        }

        //越界判定
        if (curX < 0 || curY < 0 || curX >= board.length || curY >= board[0].length) {
            return false;
        }

        //已用判定
        if (hasUsed[curX][curY]) {
            return false;
        }

        if (word.charAt(wordIndex) != board[curX][curY]) {
            return false;
        }
        hasUsed[curX][curY] = true;

        boolean res = search(board, word, wordIndex + 1, hasUsed, curX + 1, curY);
        if (res) {
            return true;
        }
        res = search(board, word, wordIndex + 1, hasUsed, curX - 1, curY);
        if (res) {
            return true;
        }

        res = search(board, word, wordIndex + 1, hasUsed, curX, curY + 1);
        if (res) {
            return true;
        }

        res = search(board, word, wordIndex + 1, hasUsed, curX, curY - 1);
        if (res) {
            return true;
        }

        hasUsed[curX][curY] = false;
        return false;
    }
}
