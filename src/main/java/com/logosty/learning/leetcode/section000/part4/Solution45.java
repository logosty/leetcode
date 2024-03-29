package com.logosty.learning.leetcode.section000.part4;

/**
 * @author ganyingle <ganyingle@kuaishou.com>
 * Created on 2023/6/8
 * description: 45. 跳跃游戏 II 中等
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 *
 *
 * 1 ms
 * 击败
 * 98.96%
 */
public class Solution45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int start = 1;
        int end = nums[0];
        int step = 1;
        int maxIndex = nums[0];

        while (maxIndex < nums.length - 1) {
            for (int i = start; i <= end && i < nums.length; i++) {
                maxIndex = Math.max(maxIndex, i + nums[i]);
            }
            start = end + 1;
            end = maxIndex;
            step++;
        }
        return step;
    }

    public int jump2(int[] nums) {
        int length = nums.length;
        if (length <= 2) {
            return length - 1;
        }
        int res = 0;
        int left = 1;
        int right = nums[0];
        while (true) {
            res++;
            if (right >= length - 1) {
                return res;
            }
            int tmpRight = right + nums[right];
            int tmpLeft = right + 1;
            int max = nums[right];

            for (int i = right - 1; i >= left; i--) {
                max++;
                if (nums[i] <= max) {
                    continue;
                }
                tmpRight = i + nums[i];
                max = nums[i];
            }
            right = tmpRight;
            left = tmpLeft;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[] {5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8};
        System.out.println(new Solution45().jump(nums));
    }
}
