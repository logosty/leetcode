package com.logosty.learning.leetcode.part40;

import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;

/**
 * @author logosty(ganyingle) on 2020/5/19 17:37 404 左叶子之和 简单 计算给定二叉树的所有左叶子之和。
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution404 {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return ((root.left != null && root.left.left == null && root.left.right == null) ? root.left.val : 0)
        + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
  }

  public static void main(String[] args) {
    TreeNode treeNode = TreeUtil.stringToTreeNode("[1,2,3,4,5]");
    int i = new Solution404().sumOfLeftLeaves(treeNode);
    System.out.println(i);
  }
}

