package com.logosty.learning.leetcode.section000.part7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author logosty(ganyingle) on 2024/3/8 17:16
 * description: 77 组合 中等
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Solution77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> used = new Stack<>();
        process(n, k, used, res);
        return res;
    }

    /**
     * 78ms击败5.17%使用 Java 的用户
     */
    private void process(int cur, int rest, Stack<Integer> used, List<List<Integer>> res) {
        if (rest == 0) {
            List<Integer> list = new ArrayList<>(used);
            res.add(list);
            return;
        }
        if (cur == 0) {
            return;
        }

        //不要当前值
        process(cur - 1, rest, used, res);

        //要当前值
        used.push(cur);
        process(cur - 1, rest - 1, used, res);
        used.pop();
    }

}
