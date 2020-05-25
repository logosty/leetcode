package com.logosty.learning.leetcode.part11;

import com.alibaba.fastjson.JSON;
import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author logosty(ganyingle) on 2020/5/22 16:53
 * 113. 路径总和 II 中等
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Solution113 {

  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> pathSum(TreeNode root, int sum) {

    return res;
  }

  public List<List<Integer>> pathSum2(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    loop(root, root, sum, 0, "1", res);
    return res;
  }

  public void loop(TreeNode root, TreeNode node, int sum, int currentSum, String sequence,
      List<List<Integer>> res) {
    if (node.left == null && node.right == null) {
      if (node.val + currentSum == sum) {
        res.add(deserialize(root, sequence));
        return;
      }
    }
    if (node.left != null) {
      loop(root, node.left, sum, currentSum + node.val, serialize(sequence, false), res);
    }
    if (node.right != null) {
      loop(root, node.right, sum, currentSum + node.val, serialize(sequence, true), res);
    }
  }

  public String serialize(String sequence, boolean isShiftRight) {
    return sequence + (isShiftRight ? "1" : "0");
  }

  public List<Integer> deserialize(TreeNode root, String sequence) {
    char[] chars = sequence.toCharArray();

    List<Integer> res = new ArrayList<>();
    for (int i = 1; i < chars.length; i++) {
      res.add(root.val);

      if (chars[i] == '0') {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    res.add(root.val);
    return res;
  }

  public static void main(String[] args) {
    TreeNode node = TreeUtil.stringToTreeNode("[1,2]");
    List<List<Integer>> lists = new Solution113().pathSum(node, 3);
    System.out.println(JSON.toJSONString(lists));

  }
}
