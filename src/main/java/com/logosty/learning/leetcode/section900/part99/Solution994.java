package com.logosty.learning.leetcode.section900.part99;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2025/10/29 16:22
 * description: 994. 腐烂的橘子 中等
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class Solution994 {
    int left = 0;
    int time = 0;

    public int orangesRotting(int[][] grid) {
        //初始化
        Set<Integer> original = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (grid[i][j] == 1) {
                    left++;
                } else {
                    original.add(i * 10 + j);
                }
            }
        }

        original = bfs(grid, original);
        while (!original.isEmpty()) {
            original = bfs(grid, original);
            time++;
        }
        return left > 0 ? -1 : time;
    }


    //坐标： length*i + j
    private Set<Integer> bfs(int[][] grid, Set<Integer> targets) {
        Set<Integer> newTargets = new HashSet<>();
        for (int target : targets) {
            int i = target / 10;
            int j = target % 10;

            if (grid[i][j] == 2 && time != 0) {
                continue;
            }
            //当前腐化
            if (grid[i][j] == 1) {
                newTargets.remove(target);
                grid[i][j] = 2;
                left--;
            }
            //找邻居，重复加入也没事

            //上
            if (i > 0 && grid[i - 1][j] == 1) {
                newTargets.add(10 * (i - 1) + j);
            }
            //下
            if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                newTargets.add(10 * (i + 1) + j);
            }
            //左
            if (j > 0 && grid[i][j - 1] == 1) {
                newTargets.add(10 * i + (j - 1));
            }
            //右
            if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
                newTargets.add(10 * i + (j + 1));
            }
        }
        return newTargets;
    }

    public static void main(String[] args) {
        int[][] ints = {{2, 2}, {1, 1}, {0, 0}, {2, 0}};
        System.out.println(new Solution994().orangesRotting(ints));
    }

}
