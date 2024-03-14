package com.logosty.learning.leetcode.section100.part12;

import java.util.List;

/**
 * @author logosty(ganyingle) on 2024/3/14 16:31
 * description: 120. 三角形最小路径和 中等
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i +
 * 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class Solution120 {

    //暴力
    //5ms击败27.29%使用 Java 的用户
    // 时间复杂度：O(n), 空间复杂度 1，改变原数组
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size == 1) {
            return triangle.get(0).get(0);
        }
        int res = Integer.MAX_VALUE;

        for (int i = 1; i < size; i++) {
            List<Integer> lastLine = triangle.get(i - 1);
            List<Integer> curLine = triangle.get(i);

            int curLineSize = curLine.size();
            curLine.set(0, lastLine.get(0) + curLine.get(0));
            curLine.set(curLineSize - 1, lastLine.get(lastLine.size() - 1) + curLine.get(curLineSize - 1));

            for (int j = 1; j < curLineSize - 1; j++) {
                curLine.set(j, curLine.get(j) + Math.min(lastLine.get(j), lastLine.get(j - 1)));
            }
        }

        for (int i = 0; i < triangle.get(size - 1).size(); i++) {
            res = Math.min(res, triangle.get(size - 1).get(i));
        }
        return res;
    }
}
