package com.logosty.learning.leetcode.section2900.part295;

import java.util.HashSet;
import java.util.Set;

/**
 * @author logosty(ganyingle) on 2024/7/16 15:32
 * description: 2956. 找到两个数组中的公共元素 简单
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。请你计算以下两个数值：
 *
 * answer1：使得 nums1[i] 在 nums2 中出现的下标 i 的数量。
 * answer2：使得 nums2[i] 在 nums1 中出现的下标 i 的数量。
 * 返回 [answer1, answer2]。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [2,3,2], nums2 = [1,2]
 *
 * 输出：[2,1]
 *
 * 解释：
 *
 *
 *
 * 示例 2：
 *
 * 输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
 *
 * 输出：[3,4]
 *
 * 解释：
 *
 * nums1 中下标在 1，2，3 的元素在 nums2 中也存在。所以 answer1 为 3。
 *
 * nums2 中下标在 0，1，3，4 的元素在 nums1 中也存在。所以 answer2 为 4。
 *
 * 示例 3：
 *
 * 输入：nums1 = [3,4,2,3], nums2 = [1,5]
 *
 * 输出：[0,0]
 *
 * 解释：
 *
 * nums1 和 nums2 中没有相同的数字，所以答案是 [0,0]。
 *
 *
 *
 * 提示：
 *
 * n == nums1.length
 * m == nums2.length
 * 1 <= n, m <= 100
 * 1 <= nums1[i], nums2[i] <= 100
 */
public class Section2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }

        int count2 = 0;
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
            if (set1.contains(nums2[i])) {
                count2++;
            }
        }

        int count1 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (set2.contains(nums1[i])) {
                count1++;
            }
        }

        return new int[]{count1, count2};
    }
}
