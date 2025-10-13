package com.logosty.learning.leetcode.section1000.part100;

/**
 * @author logosty(ganyingle) on 2025/10/13 09:08
 * description: 1004. 最大连续1的个数 III 中等
 * 给定一个二进制数组 nums 和一个整数 k，假设最多可以翻转 k 个 0 ，则返回执行操作后 数组中连续 1 的最大个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 */
public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0;//窗口左边的位置
        int maxWindow = 0;//窗口的最大值
        int zeroCount = 0;//窗口中0的个数
        for (int right = 0; right < A.length; right++) {
            if (A[right] == 0) {
                zeroCount++;
            }
            //如果窗口中0的个数超过了K，要缩小窗口的大小，直到0的个数
            //不大于K位置
            while (zeroCount > K) {
                if (A[left++] == 0) {
                    zeroCount--;
                }
            }
            //记录最大的窗口
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        System.out.println(new Solution1004().longestOnes(nums, 3));

    }
}
