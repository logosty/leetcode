package com.logosty.learning.leetcode.section000.part5;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ganyingle <ganyingle@kuaishou.com>
 * Created on 2023-03-21
 * description: 55. 跳跃游戏 中等
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 * 击败 5.1%
 */
public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int maxIndex = nums[0];

        for (int i = 1; i <= maxIndex && i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
        }

        return maxIndex >= nums.length - 1;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3};
        System.out.println(new Solution55().canJump(nums));
    }

    /**
     * 94%
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int energy = 0;
        for (int i = 0; i < nums.length; i++, energy--) {
            if (nums[i] > energy) {
                energy = nums[i];
            }
            if (energy + i >= nums.length - 1) {
                return true;
            }
            if (energy == 0) {
                return false;
            }

        }
        return false;
    }

    public boolean canJump3(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        byte[] cache = new byte[nums.length];
        boolean judge = judgeAndCache(cache, nums, 0);
        System.out.println(JSONObject.toJSON(cache));
        return judge;
    }

    private boolean judgeAndCache(byte[] cache, int[] nums, int curIndex) {
        if (cache[curIndex] != 0) {
            System.out.println("use Cache:" + curIndex + "::" + cache[curIndex]);
            return cache[curIndex] > 0;
        }
        boolean res = judge(cache, nums, curIndex);
        if (res) {
            for (int i = 0; i <= nums[curIndex] && curIndex + i < cache.length; i++) {
                cache[curIndex + i] = (byte) 1;
            }
            return true;
        } else {
            cache[curIndex] = (byte) -1;
            return false;
        }
    }

    private boolean judge(byte[] cache, int[] nums, int curIndex) {
        if (curIndex == nums.length - 1) {
            return true;
        }
        int num = nums[curIndex];
        if (num == 0) {
            return false;
        }

        for (int i = 1; i <= num; i++) {
            if (judgeAndCache(cache, nums, curIndex + i)) {
                return true;
            }
        }
        return false;
    }
}
