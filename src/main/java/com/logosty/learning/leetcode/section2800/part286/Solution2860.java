package com.logosty.learning.leetcode.section2800.part286;

import java.util.Collections;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2024/9/4 12:07
 * description: 2860. 让所有学生保持开心的分组方法数 中等
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，其中 n 是班级中学生的总数。班主任希望能够在让所有学生保持开心的情况下选出一组学生：
 * <p>
 * 如果能够满足下述两个条件之一，则认为第 i 位学生将会保持开心：
 * <p>
 * 这位学生被选中，并且被选中的学生人数 严格大于 nums[i] 。
 * 这位学生没有被选中，并且被选中的学生人数 严格小于 nums[i] 。
 * 返回能够满足让所有学生保持开心的分组方法的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1]
 * 输出：2
 * 解释：
 * 有两种可行的方法：
 * 班主任没有选中学生。
 * 班主任选中所有学生形成一组。
 * 如果班主任仅选中一个学生来完成分组，那么两个学生都无法保持开心。因此，仅存在两种可行的方法。
 * 示例 2：
 * <p>
 * 输入：nums = [6,0,3,3,6,7,2,7]
 * 输出：3
 * 解释：
 * 存在三种可行的方法：
 * 班主任选中下标为 1 的学生形成一组。
 * 班主任选中下标为 1、2、3、6 的学生形成一组。
 * 班主任选中所有学生形成一组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] < nums.length
 */
public class Solution2860 {
    public int countWays(List<Integer> nums) {
        int len = nums.size();
        Collections.sort(nums);

        int include = 0;

        int res = 0;
        if (nums.get(0) > 0) {
            res++;
        }

        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);

            //包含
            include++;

            if (include > num) {
                if (i == nums.size() - 1 || nums.get(i+1) > include) {
                    res++;
                }
            }

        }
        return res;
    }
}
