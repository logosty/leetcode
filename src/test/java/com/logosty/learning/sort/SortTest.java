package com.logosty.learning.sort;

import org.junit.Assert;
import org.junit.Test;

import com.logosty.learning.dataStructureAndAlgorithm.sort.BucketSort;
import com.logosty.learning.dataStructureAndAlgorithm.sort.DefaultSort;
import com.logosty.learning.dataStructureAndAlgorithm.sort.HeapSort;
import com.logosty.learning.dataStructureAndAlgorithm.sort.Mergesort;
import com.logosty.learning.dataStructureAndAlgorithm.sort.Quicksort;

public class SortTest {

    @Test
    public void defaultSort() {
        Assert.assertTrue(new DefaultSort().sortAndCheckRandom());
    }

    @Test
    public void Mergesort() {
        Assert.assertTrue(new Mergesort().sortAndCheckRandom());
    }

    @Test
    public void Quicksort() {
        Assert.assertTrue(new Quicksort().sortAndCheckRandom());
    }

    @Test
    public void HeapSort() {
        Assert.assertTrue(new HeapSort().sortAndCheckRandom());
    }

    @Test
    public void BucketSort() {
        Assert.assertTrue(new BucketSort().sortAndCheckRandom(100, 20));
    }
}