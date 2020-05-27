package com.logosty.learning.leetcode.section000.part6;

/**
 * Created with IDEA by logosty
 * Date:2019/4/2 Time:17:37
 * Description: 简单 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            }
            digits[i] = 0;
        }

        if (digits[0] == 0) {
            int[] newArr = new int[digits.length + 1];
            newArr[0] = 1;
            System.arraycopy(digits, 1, newArr, 2, digits.length - 1);
            digits = newArr;
        }

        return digits;
    }
}
