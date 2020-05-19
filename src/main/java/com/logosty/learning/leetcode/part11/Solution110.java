package com.logosty.learning.leetcode.part11;

import com.logosty.learning.util.pojo.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/5/19 19:51
 * 110. 平衡二叉树 简单
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution110 {

  private Map<TreeNode, Integer> map = new HashMap<>();

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    int l = getDepth(root.left);
    int r = getDepth(root.right);
    if (l - r > 1 || r - l > 1) {
      return false;
    }
    return isBalanced(root.left) && isBalanced(root.right);
  }

  public int getDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (map.get(root) != null) {
      return map.get(root);
    }
    return Math.max(getDepth(root.right), getDepth(root.left)) + 1;
  }

  public static void main(String[] args) {

  }
}
