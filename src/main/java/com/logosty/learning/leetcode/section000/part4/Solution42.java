package com.logosty.learning.leetcode.section000.part4;

/**
 * @author logosty(ganyingle) on 2024/3/7 16:30
 * description: 42. 接雨水 困难
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 *
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 *
 * 提示：
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */
public class Solution42 {

    /**
     * 逐列考虑，看两边的最大值是多少
     */
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }

        int[] maxLeft = new int[height.length];
        maxLeft[0] = height[0];

        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[height.length - 1 - i] = Math.max(maxRight[height.length - i], height[height.length - i]);
        }

        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (height[i] > min) {
                continue;
            }
            sum += (min - height[i]);
        }
        return sum;
    }


}
