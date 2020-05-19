package com.logosty.learning.leetcode.part1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IDEA by @author:logosty(ganyingle)
 * Date:2019/1/23 Time:19:42
 * Description: 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 1; i < nums.length - 1; i++) {
            if (i > 1 && nums[i] == nums[i - 1] && nums[i - 2] == nums[i - 1]) {
                continue;
            }
            boolean leftLimt = false;
            if (i > 1 && nums[i] == nums[i - 1]) {
                leftLimt = true;
            }


            int left = 1;
            int right = 1;

            while (true) {
                if (i - left < 0 || i + right >= nums.length || (leftLimt && left >1)) {
                    break;
                }

                if (left > 1 && nums[i - left + 1] == nums[i - left]) {
                    left++;
                    continue;
                }
                if (right > 1 && nums[i + right - 1] == nums[i + right]) {
                    right++;
                    continue;
                }

                int sum = nums[i] + nums[i - left] + nums[i + right];
                if (sum > 0) {
                    left++;
                    continue;
                }
                if (sum < 0) {
                    right++;
                    continue;
                }

                List<Integer> list = Arrays.asList(nums[i], nums[i - left], nums[i + right]);
                ret.add(list);
                left++;
                right++;

            }
        }

        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(new Solution15().threeSum(nums));
        System.out.println("[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]");
    }
}
//[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]