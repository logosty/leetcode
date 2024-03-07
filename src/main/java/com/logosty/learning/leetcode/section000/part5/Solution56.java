package com.logosty.learning.leetcode.section000.part5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2024/3/7 16:59
 * description: 56. 合并区间 中等
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class Solution56 {

    /**
     * 9
     * ms
     * 击败
     * 15.22%
     * 使用 Java 的用户
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new LinkedList<>();
        //按左边排序数组
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int i = 1; i < intervals.length; i++) {
            //重叠
            if (intervals[i][0] <= intervals[i-1][1]) {
                intervals[i][0] = intervals[i - 1][0];
                intervals[i][1] = Math.max(intervals[i - 1][1],intervals[i][1]);

            } else {
                //不重叠
                list.add(intervals[i - 1]);
            }
        }
        list.add(intervals[intervals.length - 1]);
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] ints = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(new Solution56().merge(ints)));
    }
}
