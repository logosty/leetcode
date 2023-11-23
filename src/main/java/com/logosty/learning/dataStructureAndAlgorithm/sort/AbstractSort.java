package com.logosty.learning.dataStructureAndAlgorithm.sort;

import java.util.Arrays;

import com.logosty.learning.util.ArrayUtils;

public abstract class AbstractSort {
    public abstract void sort(int[] nums);

    public boolean sortAndCheck(int[] nums) {
        System.out.println("start---------------------------");
        int[] numsCopy = new int[nums.length];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);
        ArrayUtils.printArray(nums);

        Arrays.sort(numsCopy);
        ArrayUtils.printArray("系统排序结果:", numsCopy);

        this.sort(nums);
        ArrayUtils.printArray("本法排序结果:", nums);

        boolean allPass = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != numsCopy[i]) {
                allPass = false;
                break;
            }
        }

        System.out.println("排序算法正确性为：" + allPass);
        System.out.println("end---------------------------\n");
        return allPass;
    }

    public boolean sortAndCheckRandom() {
        return sortAndCheckRandom(100, 15);
    }

    public boolean sortAndCheckRandom(int checkTimes, int length) {
        boolean allPass = true;
        for (int i = 0; i < checkTimes; i++) {
            int[] randomArray = ArrayUtils.createRandomArray(length);
            if (!sortAndCheck(randomArray)) {
                allPass = false;
            }
        }
        return allPass;
    }

}
