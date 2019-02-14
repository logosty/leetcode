package com.logosty.learning.leetcode.part190;

import java.util.Arrays;

/**
 * Created with IDEA by logosty
 * Date:2019/2/14 Time:10:10
 * Description: 简单 189. 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class Solution189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        int divisor = k > nums.length / 2 ? nums.length - k : k;
        int round = nums.length % divisor == 0 ? divisor : 1;

        for (int i = 0; i < round; i++) {

            int j = (i + k) % nums.length;
            int bef = nums[i];
            int temp;

            while (true) {
                temp = nums[j];
                nums[j] = bef;
                bef = temp;
                j = (j + k) % nums.length;

                if (j == i) {
                    nums[j] = bef;
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println("原始:" + Arrays.toString(nums));
        System.out.println("预期: [3,4,5,6,1,2]");
        new Solution189().rotate(nums, 4);
        System.out.println("结果:" + Arrays.toString(nums));

    }


}
