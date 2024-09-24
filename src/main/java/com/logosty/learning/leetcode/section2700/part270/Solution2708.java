package com.logosty.learning.leetcode.section2700.part270;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * @author logosty(ganyingle) on 2024/9/3 10:28
 * description: 2708. 一个小组的最大实力值 中等
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
 *
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,-1,-5,2,5,-9]
 * 输出：1350
 * 解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
 * 示例 2：
 *
 * 输入：nums = [-4,-5,-4]
 * 输出：20
 * 解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 13
 * -9 <= nums[i] <= 9
 */
public class Solution2708 {
    public long maxStrength(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();

        boolean lastUsed = false;
        for (int i = 1; i < nums.length && nums[i] < 0; i++) {
            if (!lastUsed) {
                lastUsed = true;
                list.add((long) (nums[i] * nums[i - 1]));
            } else {
                lastUsed = false;
            }
        }

        lastUsed = false;
        int remain = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0 && nums[i] > 0; i--) {
            remain = nums[i];
            if (!lastUsed) {
                lastUsed = true;
                list.add((long) (nums[i] * nums[i + 1]));
            } else {
                lastUsed = false;
            }
        }
        if (!lastUsed && remain > 0) {
            list.add((long) remain);
        }

        return list.stream().reduce((a, b) -> a * b).orElse(0L);
    }

    public long maxStrength2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        long min = nums[0];
        long max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            long tmpMin = min;
            //最小值
            min = LongStream.of(num, min, min * num, max * num).min().getAsLong();
            //最大值
            max = LongStream.of(num, max, max * num, tmpMin * num).max().getAsLong();
        }

        for (int num : nums) {


        }
        return max;
    }

}