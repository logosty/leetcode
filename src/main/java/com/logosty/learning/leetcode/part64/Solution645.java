package com.logosty.learning.leetcode.part64;

import com.alibaba.fastjson.JSON;
import com.logosty.learning.annotation.ToOptimization;
import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/5/26 15:05
 * 645. 错误的集合 简单
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。
 *
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,2,4]
 * 输出: [2,3]
 * 注意:
 *
 * 给定数组的长度范围是 [2, 10000]。
 * 给定的数组是无序的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/set-mismatch
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@ToOptimization
public class Solution645 {

  public int[] findErrorNums(int[] nums) {
    int target = 0;
    int actual = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int repeat = 0;

    for (int i = 0; i < nums.length; i++) {
      target = target + i + 1;
      actual = actual + nums[i];
      if (repeat == 0 && map.get(nums[i]) != null) {
        repeat = nums[i];
      } else {
        map.put(nums[i], i);
      }
    }
    return new int[]{repeat, -(actual - target - repeat)};
  }

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 2, 4};
    System.out.println(JSON.toJSONString(new Solution645().findErrorNums(nums)));
  }
}
