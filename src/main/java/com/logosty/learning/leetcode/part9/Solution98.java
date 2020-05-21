package com.logosty.learning.leetcode.part9;

import com.logosty.learning.util.TreeUtil;
import com.logosty.learning.util.pojo.TreeNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @author logosty(ganyingle) on 2020/5/20 17:19
 * 98. 验证二叉搜索树 中等
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution98 {

  private static Map<TreeNode, Integer> maxMap = new HashMap<>();
  private static Map<TreeNode, Integer> minMap = new HashMap<>();

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }

    maxMap.put(root, root.val);
    minMap.put(root, root.val);
    if (root.right == null && root.left == null) {
      return true;
    }

    if (!isValidBST(root.left) || !isValidBST(root.right)) {
      return false;
    }

    if (root.left != null) {
      if (root.val <= root.left.val || root.val <= maxMap.get(root.left)) {
        return false;
      }
      minMap.put(root, root.left.val);
    }

    if (root.right != null) {
      if (root.val >= root.right.val || root.val >= minMap.get(root.right)) {
        return false;
      }
      maxMap.put(root, maxMap.get(root.right));
    }
    return true;
  }

  public static void main(String[] args) {
    TreeNode treeNode = TreeUtil.stringToTreeNode("[10,5,15,null,null,6,20]");
    System.out.println(new Solution98().isValidBST(treeNode));

  }
}
