package com.logosty.learning.dataStructureAndAlgorithm.sort;

/**
 * @author logosty(ganyingle) on 2023/11/17 16:37
 * description: 归并排序
 */
public class Mergesort extends AbstractSort{

    @Override
    public void sort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        process(nums, 0, nums.length - 1);
    }

    public void process(int[] nums, int L, int R) {
        if (L == R) {
            return;
        }

        int M = L + (R - L) / 2;
        process(nums, L, M);
        process(nums, M + 1, R);
        merge(nums, L, R, M);
    }

    public void merge(int[] nums, int L, int R, int M) {
        int[] help = new int[R - L + 1];

        int helpPos = 0;
        int LPos = L;
        int RPos = M + 1;
        while (LPos <= M && RPos <= R) {
            if (nums[LPos] <= nums[RPos]) {
                help[helpPos++] = nums[LPos++];
            } else {
                help[helpPos++] = nums[RPos++];
            }
        }
        while (LPos <= M) {
            help[helpPos++] = nums[LPos++];
        }
        while (RPos <= R) {
            help[helpPos++] = nums[RPos++];
        }

        for (int i = 0; i < help.length; i++) {
            nums[L + i] = help[i];
        }
    }
}
