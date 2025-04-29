package com.logosty.learning.leetcode.section200.part21;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2025/4/29 19:25
 * description: 219. 存在重复元素 II 简单
 * 给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 0 <= k <= 105
 */
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) {
            return false;
        }

        int left = 0;
        int right = 1;
        Set<Integer> cache = new HashSet<>();
        cache.add(nums[0]);

        for (; right < nums.length; right++) {
            if (cache.contains(nums[right])) {
                return true;
            }
            cache.add(nums[right]);
            if (cache.size() > k) {
                cache.remove(nums[left++]);
            }
        }

        return false;
    }
}
