package com.logosty.learning.leetcode.section000.part3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ganyingle <ganyingle@kuaishou.com>
 * Created on 2023-03-20
 * description: 39. 组合总和 中等
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * <p>
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * <p>
 * 输入: candidates = [2], target = 1
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * candidates 的所有元素 互不相同
 * 1 <= target <= 40
 */
public class Solution39 {
    private static Map<Integer, List<List<Integer>>> cache = new HashMap<>();
    private static byte[] bytes = new byte[41];

    public static void main(String[] args) {
        int[] candidates = new int[] {2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = new Solution39().combinationSum(candidates, target);
        System.out.println(JSONObject.toJSON(lists));

    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 2) {
            return Collections.emptyList();
        }

        for (int candidate : candidates) {
            bytes[candidate] = 1;
        }

        return calOne(target);
    }

    public List<List<Integer>> calOneAndCache(int target) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        List<List<Integer>> lists = calOne(target);

        cache.put(target, lists);
        return lists;
    }

    public List<List<Integer>> calOne(int target) {
        System.out.println("搜索：" + target);
        List<List<Integer>> res;

        if (target == 3 || target == 2) {
            if (bytes[target] == 0) {
                return Collections.emptyList();
            }
            res = new ArrayList<>();
            res.add(List.of(target));
        }

        res = new ArrayList<>();
        if (bytes[target] != 0) {
            res.add(List.of(target));
        }
        for (int i = 2; i <= target / 2; i++) {
            List<List<Integer>> cal1 = calOneAndCache(i);
            if (i == target - i) {
                res.addAll(merge(cal1));
                return res;
            }

            List<List<Integer>> cal2 = calOneAndCache(target - i);
            res.addAll(merge(cal1, cal2));
        }
        return res;
    }

    public List<List<Integer>> merge(List<List<Integer>> l1, List<List<Integer>> l2) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            for (int j = 0; j < l2.size(); j++) {
                List<Integer> one = new ArrayList<>();
                one.addAll(l1.get(i));
                one.addAll(l2.get(j));
                res.add(one);
            }
        }
        return res;
    }

    public List<List<Integer>> merge(List<List<Integer>> l1) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < l1.size(); i++) {
            for (int j = i; j < l1.size(); j++) {
                List<Integer> one = new ArrayList<>();
                one.addAll(l1.get(i));
                one.addAll(l1.get(j));
                res.add(one);
            }
        }
        return res;
    }
}
