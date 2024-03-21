package com.logosty.learning.leetcode.section200.part25;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author logosty(ganyingle) on 2024/3/21 16:05
 * description: 252.会议室 简单
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 * 示例 2：
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti < endi <= 106
 */
public class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(value -> value[0]));

        int rightMax = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < rightMax) {
                return false;
            }
            rightMax = Math.max(rightMax, intervals[i][1]);
        }
        return true;
    }
}
