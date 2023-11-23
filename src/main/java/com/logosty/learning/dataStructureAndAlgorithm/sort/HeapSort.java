package com.logosty.learning.dataStructureAndAlgorithm.sort;

import com.logosty.learning.dataStructureAndAlgorithm.heap.Heap;

/**
 * @author logosty(ganyingle) on 2023/11/23 15:49
 * description: 堆排序
 */
public class HeapSort extends AbstractSort{

    @Override
    public void sort(int[] nums) {
        Heap heap = new Heap(nums);
        int index = 0;
        while (heap.hasNum()) {
            nums[index++] = heap.popMin();
        }

    }
}
