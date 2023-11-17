package com.logosty.learning.leetcode.section300.part32;

/**
 * 327. 区间和的个数
 * 困难
 * 给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
 *
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 *
 * 示例 1：
 * 输入：nums = [-2,5,-1], lower = -2, upper = 2
 * 输出：3
 * 解释：存在三个区间：[0,0]、[2,2] 和 [0,2] ，对应的区间和分别是：-2 、-1 、2 。
 * 示例 2：
 *
 * 输入：nums = [0], lower = 0, upper = 0
 * 输出：1
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * -105 <= lower <= upper <= 105
 * 题目数据保证答案是一个 32 位 的整数
 */

public class Solution327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return match(nums[0], lower, upper) ? 1 : 0;
        }
        int[] sums = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] = nums[i];
        }
        //转换成sum前缀和数组了
        return process(sums, 0, nums.length - 1, lower, upper);
    }

    private int process(int[] sums, int L, int R, int lower, int upper) {
        if (L == R) {
            return match(sums[L], lower, upper) ? 1 : 0;
        }
        int M = L + (R - L) / 2;

        return process(sums, L, M, lower, upper)
                + process(sums, M + 1, R, lower, upper)
                + merge(sums, L, R, M, lower, upper);

    }

    private int merge(int[] sums, int L, int R, int M, int lower, int upper) {
        int LWindow = L;
        int RWindow = M + 1;

        int[] help = new int[R - L + 1];
        int helpIndex = 0;

        int res = 0;

        while (LWindow <= M && RWindow <= R) {
            if (sums[LWindow] <= sums[RWindow]) {
                help[helpIndex++] = sums[LWindow++];
                continue;
            }
            help[helpIndex++] = sums[RWindow++];
        }

        while (LWindow <= M) {
            help[helpIndex++] = sums[LWindow++];
        }
        while ( RWindow <= R) {
            help[helpIndex++] = sums[RWindow++];
        }

        //计算数值
        for (int i = M + 1; i <= R; i++) {
            for (int j = L; j <= M; j++) {
                if (match(sums[j], sums[i] - upper, sums[i] - lower)) {
                    res++;
                }
            }
        }

        return res;
    }

    private boolean match(int num, int lower, int upper) {
        return num <= upper && num >= lower;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,5,-1}; int lower = -2; int upper =2;
        System.out.println(new Solution327().countRangeSum(nums, lower, upper));
    }
}
