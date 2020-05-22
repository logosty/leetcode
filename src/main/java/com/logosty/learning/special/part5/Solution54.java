package com.logosty.learning.special.part5;

import com.logosty.learning.util.pojo.TreeNode;
import java.util.Stack;

/**
 * @author logosty(ganyingle) on 2020/5/22 16:17
 * 面试题54. 二叉搜索树的第k大节点 简单
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution54 {

  public int kthLargest(TreeNode root, int k) {
    int current = 0;
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    boolean isBacktrack = false;

    while (!stack.empty()) {
      TreeNode node = stack.pop();
      if (node.left == null && node.right == null) {
        isBacktrack = true;
        if (k == ++current) {
          return node.val;
        }
        continue;
      }
      if (isBacktrack) {
        if (k == ++current) {
          return node.val;
        }
        if (node.left != null) {
          isBacktrack = false;
        }
        continue;
      }

      if (node.left != null) {
        stack.push(node.left);
      }
      stack.push(node);
      if (node.right != null) {
        stack.push(node.right);
      } else {
        isBacktrack = true;
      }
    }

    return root.val;
  }

}
