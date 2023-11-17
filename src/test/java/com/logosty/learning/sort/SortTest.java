package com.logosty.learning.sort;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {

    @Test
    public void defaultSort() {
        Assert.assertTrue(new DefaultSort().sortAndCheckRandom());
    }

    @Test
    public void Mergesort() {
        Assert.assertTrue(new Mergesort().sortAndCheckRandom());
    }
}