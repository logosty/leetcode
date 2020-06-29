package com.logosty.learning.leetcode.section200.part21;

import java.util.Arrays;

/**
 * @author logosty(ganyingle) on 2020/6/29 14:24
 * 215. 数组中的第K个最大元素 中等
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Solution215 {

  public int findKthLargest(int[] nums, int k) {
    Heap heap = new Heap(nums.length);
    for (int i = 0; i < nums.length; i++) {
      heap.insert(nums[i]);
    }

    int last = heap.pop();
    for (int i = 1; ; ) {
      if (k == i) {
        return last;
      }
      int pop = heap.pop();
//      if (pop == last) {
//        continue;
//      }
      last = pop;
      i++;
    }
  }

  static class Heap {

    private int[] data;
    private int size;

    public Heap(int size) {
      data = new int[size];
      this.size = 0;
    }

    public int getSize() {
      return size;
    }

    public int pop() {
      if (size == 0) {
        throw new IndexOutOfBoundsException("堆中没有元素");
      }
      int ret = data[0];
      size--;
      if (size != 0) {
        data[0] = data[size];
        shiftDown(0);
      }
      return ret;
    }

    public void insert(int value) {
      if (size + 1 > data.length) {
        //扩容
        data = Arrays.copyOf(data, data.length * 2);
      }
      size++;
      data[size - 1] = value;
      shiftUp(size - 1);
    }

    private void shiftUp(int index) {
      int parent = getParent(index);
      if (outOfBounds(parent)) {
        return;
      }

      if (data[index] <= data[parent]) {
        return;
      }
      swap(index, parent);
      shiftUp(parent);
    }

    private void shiftDown(int index) {
      int left = getLeft(index);
      int right = getRight(index);
      if (outOfBounds(left)) {
        return;
      }
      int target = left;
      if (!outOfBounds(right)) {
        target = data[left] > data[right] ? left : right;
      }

      if (data[index] >= data[target]) {
        return;
      }
      swap(index, target);
      shiftDown(target);
    }

    private boolean outOfBounds(int index) {
      return index < 0 || index >= size;
    }

    private void swap(int index1, int index2) {
      data[index1] = data[index1] ^ data[index2];
      data[index2] = data[index1] ^ data[index2];
      data[index1] = data[index1] ^ data[index2];
    }

    private int getParent(int index) {
      return (index - 1) / 2;
    }

    private int getLeft(int index) {
      return 2 * index + 1;
    }

    private int getRight(int index) {
      return 2 * index + 2;
    }

  }

  public static void main(String[] args) {
    int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    System.out.println(new Solution215().findKthLargest(ints, k));
  }
}
