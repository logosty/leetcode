package com.logosty.learning.leetcode.section000.part3;

/**
 * @author logosty(ganyingle) on 2020/6/24 16:03
 * 33. 搜索旋转排序数组 中等
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Solution33 {

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }

    int pos = findTurnPos(nums, 0, nums.length - 1);
    return findTarget(nums, target, pos, pos + nums.length - 1);

  }

  private int findTarget(int[] nums, int target, int start, int end) {
    int startInx = start % nums.length;
    int endInx = end % nums.length;

    int middle = (start + end) / 2;
    int middleInx = middle % nums.length;

    if (nums[middleInx] == target) {
      return middleInx;
    }

    if (end == start + 1) {
      return nums[endInx] == target ? endInx : -1;
    }

    if (nums[middleInx] > target) {
      return findTarget(nums, target, start, middle);
    } else {
      return findTarget(nums, target, middle, end);
    }

  }

  private int findTurnPos(int[] nums, int start, int end) {
    if (start == end || nums[end] > nums[start]) {
      return start;
    }
    int i = (end + start) / 2;
    if ((i > 0 && nums[i] < nums[i - 1])) {
      return i;
    }
    if (nums[i + 1] < nums[i]) {
      return i + 1;
    }

    if (nums[i] > nums[start]) {
                      return findTurnPos(nums, i, end);
    } else {
      return findTurnPos(nums, start, i);
    }
  }

  public static void main(String[] args) {
    int[] ints;
    int target;

    ints = new int[]{3,4,5,6,1,2};
    target = 2;
    System.out.println(new Solution33().search(ints, target));

    ints = new int[]{4, 5, 6, 7, 0, 1, 2};
    target = 4;
    System.out.println(new Solution33().search(ints, target));

    ints = new int[]{1, 3};
    target = 3;
    System.out.println(new Solution33().search(ints, target));

    ints = new int[]{4, 5, 6, 7, 0, 1, 2};
    target = 3;
    System.out.println(new Solution33().search(ints, target));

    ints = new int[]{4, 5, 6, 7, 0, 1, 2};
    target = 0;
    System.out.println(new Solution33().search(ints, target));
  }
}
