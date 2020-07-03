package com.logosty.learning.leetcode.section100.part10;

import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/7/3 16:34
 * 108. 将有序数组转换为二叉搜索树 简单
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution102 {

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length == 0) {
      return null;
    }

    return buildNode(nums, 0, nums.length - 1);
  }

  public TreeNode buildNode(int[] nums, int begin, int end) {
    int middle = begin + (end - begin) / 2;
    TreeNode node = new TreeNode(nums[middle]);
    if (middle != begin) {
      node.left = buildNode(nums, begin, middle - 1);
    }
    if (middle != end) {
      node.right = buildNode(nums, middle + 1, end);
    }
    return node;
  }

  public static void main(String[] args) {
  }
}
