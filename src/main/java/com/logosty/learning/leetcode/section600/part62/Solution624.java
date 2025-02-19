package com.logosty.learning.leetcode.section600.part62;

import java.util.List;

/**
 * @author logosty(ganyingle) on 2025/2/19 16:05
 * description: 624. 数组列表中的最大距离 中等
 * 给定 m 个数组，每个数组都已经按照升序排好序了。
 * <p>
 * 现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
 * <p>
 * 返回最大距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,2,3],[4,5],[1,2,3]]
 * 输出：4
 * 解释：
 * 一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
 * 示例 2：
 * <p>
 * 输入：arrays = [[1],[1]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == arrays.length
 * 2 <= m <= 105
 * 1 <= arrays[i].length <= 500
 * -104 <= arrays[i][j] <= 104
 * arrays[i] 以 升序 排序。
 * 所有数组中最多有 105 个整数。
 */
public class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = Integer.MIN_VALUE;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            res = Math.max(res, Math.abs(list.get(0) - max));
            res = Math.max(res, Math.abs(list.get(list.size() - 1) - min));

            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(list.size() - 1));
        }
        return res;
    }
}
