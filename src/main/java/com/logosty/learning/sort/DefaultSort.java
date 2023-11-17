package com.logosty.learning.sort;

import java.util.Arrays;

public class DefaultSort extends AbstractSort{

    @Override
    public void sort(int[] nums) {
        Arrays.sort(nums);
    }
}
