package com.logosty.learning.dataStructureAndAlgorithm.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author logosty(ganyingle) on 2023/11/29 15:41
 * description: 基数排序
 */
public class RadixSort extends AbstractSort {
    @Override
    public void sort(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int radix = 0;
        while (max != 0) {
            radix++;
            max /= 10;
        }

        Queue<Integer>[] queues = new Queue[10];

        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }

        for (int i = 0; i < radix; i++) {
            for (int i1 = 0; i1 < nums.length; i1++) {
                int num = nums[i1];
                int bucket = num;
                if (i > 0) {
                    bucket = num / (i * 10); //移位
                }
                bucket = bucket % 10; //取余
                queues[bucket].add(num);
            }

            int index = 0;
            for (int j = 0; j < queues.length; j++) {
                Queue<Integer> queue = queues[j];
                while (!queue.isEmpty()) {
                    nums[index++] = queue.poll();
                }
            }

        }

    }
}
