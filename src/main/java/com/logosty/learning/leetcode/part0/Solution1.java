package com.logosty.learning.leetcode.part0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2018/11/12 Time:14:11
 * Description:
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 */
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int[] ret = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                ret[0] = map.get(nums[i]);
                ret[1] = i;
                return ret;
            }
            map.put(target - nums[i], i);

        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ret = new Solution1().twoSum(nums, target);
        System.out.println(Arrays.toString(ret));
    }
}
