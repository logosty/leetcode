package com.logosty.learning.leetcode.section000.part28;

import com.logosty.learning.annotation.ToOptimization;

/**
 * @author logosty(ganyingle) on 2020/5/26 10:37
 * 287. 寻找重复数 中等
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@ToOptimization
public class Solution287 {
  public int findDuplicate(int[] nums) {
    int buff = 0;
    for (int i = 0; i < nums.length; i++) {
      int bit = 1 << ((nums[i] % 64) - 1);
      if ((buff & bit)  == 0) {
        buff = buff | bit;
        continue;
      }

      if (contains(nums, nums[i], i)) {
        return nums[i];
      }
    }

    return -1;
  }

  private boolean contains(int[] nums, int target, int border) {
    for (int i = 0; i < border; i++) {
      if (nums[i] == target) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = new int[]{3,1,3,4,2};
    System.out.println(new Solution287().findDuplicate(nums));
  }
}
