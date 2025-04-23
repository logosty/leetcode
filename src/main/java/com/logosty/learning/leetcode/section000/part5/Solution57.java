package com.logosty.learning.leetcode.section000.part5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2025/4/23 22:52
 * description: 57. 插入区间 中等
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，并且 intervals 按照 starti
 * 升序排列。同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 * <p>
 * 在 intervals 中插入区间 newInterval，使得 intervals 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 * <p>
 * 返回插入之后的 intervals。
 * <p>
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals 根据 starti 按 升序 排列
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }

        List<int[]> result = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];
        boolean hasDone = false;
        for (int i = 0; i < intervals.length; i++) {
            if (hasDone) {
                result.add(intervals[i]);
                continue;
            }

            int[] interval = intervals[i];
            //数组最大值小于目标值最小值 就无影响直接纳入结果
            if (interval[1] < start) {
                result.add(interval);
                continue;
            }

            //数组最小值大于目标最大值 从这之后都没有影响了，将目标纳入
            if (interval[0] > end) {
                result.add(new int[] {start, end});
                result.add(interval);
                hasDone = true;
                continue;
            }

            //需要合并
            start = Math.min(interval[0], start);
            end = Math.max(interval[1], end);
        }
        if (!hasDone) {
            result.add(new int[] {start, end});
        }

        return result.toArray(new int[result.size()][]);
    }
}
