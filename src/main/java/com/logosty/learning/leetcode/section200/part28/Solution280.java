package com.logosty.learning.leetcode.section200.part28;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2024/7/8 15:22
 * description: 280.摆动排序 中等
 */
public class Solution280 {
    public void wiggleSort(int[] nums) {
        boolean isLess = false;
        for (int i = 1; i < nums.length; i++) {


            if (isLess && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            } else if (!isLess && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            isLess = !isLess;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void wiggleSort2(int[] nums) {
        Arrays.sort(nums);

        int[] copied =  Arrays.copyOf(nums, nums.length);

        boolean tail = false;
        for (int i = 0; i < nums.length; i++) {
            int index = tail ? nums.length - 1 - i / 2 : i / 2;
            nums[i] = copied[index];
            tail = !tail;
        }

    }
}
