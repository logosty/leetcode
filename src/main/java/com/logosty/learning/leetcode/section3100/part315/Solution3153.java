package com.logosty.learning.leetcode.section3100.part315;

/**
 * @author logosty(ganyingle) on 2024/8/30 13:26
 * description: 3153. 所有数对中数位不同之和 中等
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 *
 * 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
 *
 * 请你返回 nums 中 所有 整数对里，数位不同之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [13,23,12]
 *
 * 输出：4
 *
 * 解释：
 * 计算过程如下：
 * - 13 和 23 的数位不同为 1 。
 * - 13 和 12 的数位不同为 1 。
 * - 23 和 12 的数位不同为 2 。
 * 所以所有整数数对的数位不同之和为 1 + 1 + 2 = 4 。
 *
 * 示例 2：
 *
 * 输入：nums = [10,10,10,10]
 *
 * 输出：0
 *
 * 解释：
 * 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。
 *
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] < 109
 * nums 中的整数都有相同的数位长度。
 */
public class Solution3153 {

    public long sumDigitDifferences(int[] nums) {
        int len = nums.length;
        int countedDigit = countDigit(nums[0]);

        int[][] digits = new int[countedDigit][10];
        for (int num : nums) {
            enterCount(num, digits);
        }

        return calDigitDifferences(digits, len);
    }

    /**
     *
     * @param digits 每一个位置上0-9的个数
     * @param total 一共有多少个数
     */
    private long calDigitDifferences(int[][] digits,int total){
        long sum = 0;
        for (int i = 0; i < digits.length; i++) {
            int hasDone = 0;
            for (int j = 0; j < 10; j++) {
                long cur = digits[i][j];
                if (cur >0){
                    sum += (total - cur - hasDone) * cur;
                    hasDone += cur;
                }
            }
        }

        return sum;
    }

    /**
     * 计算位数
     * @param num
     * @return
     */
    private int countDigit(int num){
        int res = 0;

        while (num > 0) {
            num = num / 10;
            res++;
        }
        return res;
    }

    private void enterCount(int num, int[][] digits) {
        int digit = 0;

        while (num > 0) {
            digits[digit++][num % 10]++;
            num = num / 10;
        }

    }
}
