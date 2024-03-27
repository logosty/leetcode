package com.logosty.learning.leetcode.section2500.part258;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author logosty(ganyingle) on 2024/3/27 14:03
 * description: 2580. 统计将重叠区间合并成组的方案数 中等
 * 给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
 * <p>
 * 你需要将 ranges 分成 两个 组（可以为空），满足：
 * <p>
 * 每个区间只属于一个组。
 * 两个有 交集 的区间必须在 同一个 组内。
 * 如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
 * <p>
 * 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
 * 请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranges = [[6,10],[5,15]]
 * 输出：2
 * 解释：
 * 两个区间有交集，所以它们必须在同一个组内。
 * 所以有两种方案：
 * - 将两个区间都放在第 1 个组中。
 * - 将两个区间都放在第 2 个组中。
 * 示例 2：
 * <p>
 * 输入：ranges = [[1,3],[10,20],[2,5],[4,8]]
 * 输出：4
 * 解释：
 * 区间 [1,3] 和 [2,5] 有交集，所以它们必须在同一个组中。
 * 同理，区间 [2,5] 和 [4,8] 也有交集，所以它们也必须在同一个组中。
 * 所以总共有 4 种分组方案：
 * - 所有区间都在第 1 组。
 * - 所有区间都在第 2 组。
 * - 区间 [1,3] ，[2,5] 和 [4,8] 在第 1 个组中，[10,20] 在第 2 个组中。
 * - 区间 [1,3] ，[2,5] 和 [4,8] 在第 2 个组中，[10,20] 在第 1 个组中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= ranges.length <= 105
 * ranges[i].length == 2
 * 0 <= starti <= endi <= 109
 */
public class Solution2580 {

    public int countWays(int[][] ranges) {
        if (ranges.length == 1) {
            return 2;
        }

        int merged = 0;
        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));

        int end = ranges[0][1];

        for (int i = 1; i < ranges.length; i++) {
            //无合并
            if (ranges[i][0] > end) {
                end = ranges[i][1];
                continue;
            }

            //有合并
            merged++;
            end = Math.max(end, ranges[i][1]);
        }

        int mod = (int) (Math.pow(10, 9) + 7);

        int res = 1;
        int survivor = ranges.length - merged;
        for (int i = 0; i < survivor; i++) {
            res = res * 2 % mod;
        }


        return res;
    }
}
