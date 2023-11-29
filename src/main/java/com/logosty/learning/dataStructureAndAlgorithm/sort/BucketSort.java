package com.logosty.learning.dataStructureAndAlgorithm.sort;

/**
 * @author logosty(ganyingle) on 2023/11/29 15:23
 * description: 桶排序-不基于比较的排序
 */
public class BucketSort extends AbstractSort{
    @Override
    public void sort(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] bucket = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0) {
                for (int j = 0; j < bucket[i]; j++) {
                    nums[index++] = i;
                }
            }
        }
    }
}
