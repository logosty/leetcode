package com.logosty.learning.leetcode.section2600.part268;

/**
 * @author logosty(ganyingle) on 2024/3/16 14:13
 * description: 2684. 矩阵中移动的最大次数 中等
 * 给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
 * <p>
 * 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
 * <p>
 * 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1) 三个单元格中任一满足值 严格 大于当前单元格的单元格。
 * 返回你在矩阵中能够 移动 的 最大 次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
 * 输出：3
 * 解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
 * - (0, 0) -> (0, 1).
 * - (0, 1) -> (1, 2).
 * - (1, 2) -> (2, 3).
 * 可以证明这是能够移动的最大次数。
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
 * 输出：0
 * 解释：从第一列的任一单元格开始都无法移动。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 1000
 * 4 <= m * n <= 105
 * 1 <= grid[i][j] <= 106
 */
public class Solution2684 {
    public int maxMoves(int[][] grid) {
        int maxRow = grid.length;
        int maxCol = grid[0].length;
        int res = 0;

        int[][] dp = new int[maxRow][maxCol];
        for (int col = maxCol - 2; col >= 0; col--) {
            for (int row = 0; row < maxRow; row++) {
                int curVal = grid[row][col];

                int r1 = 0;
                if (row > 0 && curVal < grid[row - 1][col + 1]) {
                    r1 = dp[row - 1][col + 1] + 1;
                }

                int r2 = 0;
                if (curVal < grid[row][col + 1]) {
                    r2 = dp[row][col + 1] + 1;
                }

                int r3 = 0;
                if (row < maxRow - 1 && curVal < grid[row + 1][col + 1]) {
                    r3 = dp[row + 1][col + 1] + 1;
                }

                dp[row][col] = Math.max(r1, Math.max(r2, r3));
                if (col == 0) {
                    res = Math.max(res, dp[row][col]);
                }
            }
        }
        return res;
    }
}
