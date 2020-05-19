package com.logosty.learning.leetcode.part22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA by logosty
 * Date:2019/4/10 Time:11:24
 * Description:中等 229. 求众数 II
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */

public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int num1 = 0, count1 = 0, num2 = 0, count2 = 0;

        //3个一比较,完全不同才删除,否则加统计值
        for (int num : nums) {
            if (num1 == num) {
                count1++;
            } else if (num2 == num) {
                count2++;
            } else if (count1 == 0) {
                num1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                num2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        //没有留值则无结果
        if (count1 == 0 && count2 == 0) {
            return ret;
        }

        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
                continue;
            }
            if (num == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            ret.add(num1);
        }
        if (count2 > nums.length / 3) {
            ret.add(num2);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new Solution229().majorityElement(nums));

    }
}
