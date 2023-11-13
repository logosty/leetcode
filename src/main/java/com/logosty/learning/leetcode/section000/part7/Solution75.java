package com.logosty.learning.leetcode.section000.part7;

import java.util.concurrent.ThreadLocalRandom;

import com.alibaba.fastjson.JSONObject;

/**
 * 75. 颜色分类
 * 提示
 * 中等
 *
 * 0ms
 * 击败 100.00%使用 Java 的用户
 *
 * 1.7K
 * 相关企业
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 *
 * 进阶：
 *
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */

public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int L = -1, R = nums.length;
        int curr = 0;
        while (curr < R) {
            //相等直接滑动
            if (nums[curr] == 1) {
                curr++;
                continue;
            }
            //小于就交换到左区间后一个
            if (nums[curr] < 1) {
                switchOne(nums, L + 1, curr);
                curr++;
                L++;
                continue;
            }

            //大于就交换到右区间前一个
            switchOne(nums, R - 1, curr);
            R--;
        }

    }

    private void switchOne(int[] nums, int first, int second) {
        if (first == second) {
            return;
        }
        nums[first] = nums[first] ^ nums[second];
        nums[second] = nums[first] ^ nums[second];
        nums[first] = nums[first] ^ nums[second];
    }

    public static void main(String[] args) {
        int[] ints = new int[1000];
        for (int i = 0; i < 1000; i++) {
            ints[i] = ThreadLocalRandom.current().nextInt(0,3);
        }

        System.out.println(JSONObject.toJSON(ints));
        new Solution75().sortColors(ints);
        System.out.println(JSONObject.toJSON(ints));

    }
}
