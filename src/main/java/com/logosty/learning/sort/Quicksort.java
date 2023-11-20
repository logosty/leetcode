package com.logosty.learning.sort;

import java.util.Arrays;

import com.logosty.learning.util.ArrayUtils;

/**
 * 快排
 */

public class Quicksort extends AbstractSort {

    @Override
    public void sort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    public void process(int[] nums, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] merged = merge(nums, L, R);
        process(nums, L, merged[0] - 1);
        process(nums, merged[1] + 1, R);
    }

    /**
     * 取最右边的作为基准，比它小的放左边，比它大的放右边
     * <p>
     * 返回目标值所处位置
     */
    public int[] merge(int[] nums, int L, int R) {
        if (L > R) {
            throw new RuntimeException("非法");
        }
        if (L == R) {
            return new int[] {L, L};
        }
        int curr = L;
        int LWin = L - 1;
        int RWin = R + 1;

        int target = nums[R];

        while (curr < RWin) {
            //大于目标值则交换右边界前一位，当前位置先不右滑
            if (nums[curr] > target) {
                ArrayUtils.switchOne(nums, curr, --RWin);
                continue;
            }
            //小于目标值则交换左边界的下一位，当前位置右滑
            if (nums[curr] < target) {
                ArrayUtils.switchOne(nums, curr++, ++LWin);
                continue;
            }
            //等于则不交换，直接右滑
            if (nums[curr] == target) {
                curr++;
            }
        }

        return new int[] {LWin + 1, RWin - 1};

    }

}
