package com.logosty.learning.leetcode.part17;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA by logosty
 * Date:2019/4/10 Time:10:23
 * Description:简单 169. 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
        int point = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                point = nums[i];
                count = 1;
                continue;
            }

            if (nums[i] == point) {
                count++;
                continue;
            }

            count--;
        }

        return point;
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>(nums.length / 2);

        for (int num : nums) {
            cache.merge(num, 1, Integer::sum);
//            cache.merge(num, 1, (x,y) -> x + 2);
        }
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        System.out.println(new Solution169().majorityElement(nums));

    }
}
