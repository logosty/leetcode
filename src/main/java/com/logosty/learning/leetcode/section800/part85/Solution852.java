package com.logosty.learning.leetcode.section800.part85;

/**
 * @author ganyingle
 * Created on 2022-07-26
 * description: 852. 山脉数组的峰顶索引 中等
 * <p>
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：arr = [0,2,1,0]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 * <p>
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 *  
 * <p>
 * 进阶：很容易想到时间复杂度 O(n) 的解决方案，你可以设计一个 O(log(n)) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexInMountainArray(arr, 0, arr.length - 1);
    }
    public int peakIndexInMountainArray(int[] arr, int start, int end) {
        if (start + 1 == end) {
            return arr[start] > arr[end] ? start : end;
        }

        int mid = start + (end - start) / 2;
        if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
            return peakIndexInMountainArray(arr, mid + 1, end);
        }
        if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
            return peakIndexInMountainArray(arr, start, mid - 1);
        }
        return -1;
    }
}
