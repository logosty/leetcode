package com.logosty.learning.leetcode.section200.part20;

import java.util.concurrent.atomic.AtomicInteger;

import com.logosty.learning.dataStructureAndAlgorithm.unionfind.UnionFind;

/**
 * @author logosty(ganyingle) on 2023/12/6 15:28
 * description: 200 岛屿的数量 中等
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ['1','1','1','1','0'],
 * ['1','1','0','1','0'],
 * ['1','1','0','0','0'],
 * ['0','0','0','0','0']
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ['1','1','0','0','0'],
 * ['1','1','0','0','0'],
 * ['0','0','1','0','0'],
 * ['0','0','0','1','1']
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class Solution200 {
    public int numIslands(char[][] grid) {
        UnionFind<Object> unionFind = new UnionFind<>();
        AtomicInteger[][] objects = new AtomicInteger[grid.length][grid[0].length];

        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                objects[i][j] = new AtomicInteger(num++);
                unionFind.addOneValue(objects[i][j]);
                //左边有点且为1，就将左边的纳入过来
                if (i > 0 && grid[i - 1][j] == '1') {
                    unionFind.union(objects[i][j], objects[i - 1][j]);
                }

                //上边有点且为1，就将上边的纳入过来
                if (j > 0 && grid[i][j - 1] == '1') {
                    unionFind.union(objects[i][j], objects[i][j - 1]);
                }
            }
        }

        return unionFind.setCount();
    }


    public static void main(String[] args) {
        char[][] grid = new char[][] {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println(new Solution200().numIslands(grid));
    }
}
